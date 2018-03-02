package com.museum.repository.impl;


import com.museum.entity.*;
import com.museum.model.filter.GuideFilter;
import com.museum.model.statistic.GuideStatistic;
import com.museum.repository.AbstractRepository;
import com.museum.repository.GuideRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class GuideRepositoryImpl extends AbstractRepository<Guide, Integer> implements GuideRepository {

    @Override
    public List<Guide> findAllByPosition(GuidePosition position) {
        String sql = "SELECT guide FROM Guide guide WHERE guide.position = :position";
        TypedQuery<Guide> query = getEntityManager().createQuery(sql, Guide.class);
        query.setParameter("position", position);
        return query.getResultList();
    }

    @Override
    public List<Guide> findAllByPeriod(LocalDateTime fromTime, LocalDateTime toTime) {
        String sql = "SELECT guide FROM Guide guide " +
                "WHERE guide NOT IN (" +
                "SELECT guide FROM Guide JOIN guide.events event " +
                "WHERE (event.startTime < :toTime AND event.finishTime > :fromTime))";
        TypedQuery<Guide> query = getEntityManager().createQuery(sql, Guide.class);
        query.setParameter("fromTime", fromTime);
        query.setParameter("toTime", toTime);
        return query.getResultList();
    }

    @Override
    public Long getWorkTime(Guide guide) {
        String sql = "SELECT SUM(TIMESTAMPDIFF(MINUTE, event.startTime, event.finishTime)) " +
                "FROM guide JOIN event ON guide.id = event.guide_id " +
                "WHERE guide.id = :guideId";
        Query query = getEntityManager().createNativeQuery(sql);
        query.setParameter("guideId", guide.getId());
        return ((BigDecimal) query.getSingleResult()).longValue();
    }

    @Override
    public Long getWorkTimeByPeriod(Guide guide, LocalDateTime fromTime, LocalDateTime toTime) {
        String sql = "SELECT SUM(TIMESTAMPDIFF(MINUTE, event.startTime, event.finishTime)) " +
                "FROM guide JOIN event ON guide.id = event.guide_id " +
                "WHERE (event.startTime >= :fromTime AND event.finishTime <= :toTime) " +
                "AND (guide.id = :guideId)";
        Query query = getEntityManager().createNativeQuery(sql);
        query.setParameter("fromTime", fromTime);
        query.setParameter("toTime", toTime);
        query.setParameter("guideId", guide.getId());
        return ((BigDecimal) query.getSingleResult()).longValue();
    }

    @Override
    public List<GuideStatistic> findAllByFilterWithStatistic(GuideFilter filter) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Tuple> query = builder.createQuery(Tuple.class);

        Root<Guide> guide = query.from(Guide.class);

        Expression<Long> eventCount = builder.count(guide.join(Guide_.events, JoinType.LEFT));
        Expression<Long> workDuration = builder.sum(guide.join(Guide_.events, JoinType.LEFT)
                .join(Event_.excursion, JoinType.LEFT).get(Excursion_.duration).as(Long.class));
        query.multiselect(guide, eventCount, workDuration);

        List<Predicate> predicates = new ArrayList<>();
        if (filter.hasFromOrToDateTime()) {
            Subquery<Guide> subQuery = query.subquery(Guide.class);
            subQuery.select(subQuery.from(Guide.class));
            Join<Guide, Event> subEvent = guide.join(Guide_.events, JoinType.LEFT);

            if (filter.hasToDateTime()) {
                subQuery.where(builder.lessThan(subEvent.get(Event_.startTime), filter.getToDateTime()));
            }
            if (filter.hasFromDateTime()) {
                subQuery.where(builder.greaterThan(subEvent.get(Event_.finishTime), filter.getFromDateTime()));
            }
            CriteriaBuilder.In<Guide> in = builder.in(guide).value(subQuery);
            predicates.add((filter.hasBusy() && filter.getBusy()) ? in : in.not());
        }
        if (filter.hasPosition()) {
            predicates.add(builder.equal(guide.get(Guide_.position), filter.getPosition()));
        }
        if (filter.hasFirstName()) {
            predicates.add(builder.like(guide.get(Guide_.firstName), "%" + filter.getFirstName() + "%"));
        }
        if (filter.hasLastName()) {
            predicates.add(builder.like(guide.get(Guide_.lastName), "%" + filter.getLastName() + "%"));
        }
        query.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
        query.groupBy(guide.get(Guide_.id));

        List<Tuple> tuples = getEntityManager().createQuery(query).getResultList();
        return tuples.stream()
                .map(tuple -> new GuideStatistic(
                        tuple.get(0, Guide.class), tuple.get(1, Long.class), tuple.get(2, Long.class)))
                .collect(Collectors.toList());
    }
}
