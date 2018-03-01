package com.museum.repository.impl;


import com.museum.entity.*;
import com.museum.model.filter.GuideFilter;
import com.museum.repository.AbstractRepository;
import com.museum.repository.GuideRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GuideRepositoryImpl extends AbstractRepository<Guide, Integer> implements GuideRepository {

    /**
     * Task 5.
     */
    @Override
    public List<Guide> findAllByPosition(GuidePosition position) {
        String sql = "SELECT guide FROM Guide guide WHERE guide.position = :position";
        TypedQuery<Guide> query = getEntityManager().createQuery(sql, Guide.class);
        query.setParameter("position", position);
        return query.getResultList();
    }

    /**
     * Task 6.
     */
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

    /**
     * Task 10.3
     */
    @Override
    public Long getWorkTime(Guide guide) {
        String sql = "SELECT SUM(TIMESTAMPDIFF(MINUTE, event.startTime, event.finishTime)) " +
                "FROM guide JOIN event ON guide.id = event.guide_id " +
                "WHERE guide.id = :guideId";
        Query query = getEntityManager().createNativeQuery(sql);
        query.setParameter("guideId", guide.getId());
        return ((BigDecimal) query.getSingleResult()).longValue();
    }


    /**
     * Task 10.4
     */
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
    public List<Guide> findAllByFilter(GuideFilter filter) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Guide> query = builder.createQuery(Guide.class);

        // From
        Root<Guide> guide = query.from(Guide.class);
        // Select
        query.select(guide);
        // Where (event.startTime < :toTime AND event.finishTime > :fromTime)
        List<Predicate> predicates = new ArrayList<>();
        if (filter.hasFreeFromOrToDateTime()) {
            Subquery<Guide> subQuery = query.subquery(Guide.class);
            Root<Guide> subGuide = subQuery.from(Guide.class);
            Join<Guide, Event> event = guide.join(Guide_.events);
            subQuery.select(subGuide);

            if (filter.hasFreeToDateTime()) {
                subQuery.where(builder.and(
                        builder.lessThan(event.get(Event_.startTime), filter.getFreeToDateTime())));
            }
            if (filter.hasFreeFromDateTime()) {
                subQuery.where(builder.and(
                        builder.greaterThan(event.get(Event_.finishTime), filter.getFreeFromDateTime())));
            }

            predicates.add(builder.in(guide).value(subQuery).not());
        }
        if (filter.hasPosition()) {
            predicates.add(builder.and(
                    builder.equal(guide.get(Guide_.position), filter.getPosition())));
        }
        if (filter.hasFirstName()) {
            predicates.add(builder.and(
                    builder.equal(guide.get(Guide_.firstName), filter.getFirstName())));
        }
        if (filter.hasLastName()) {
            predicates.add(builder.and(
                    builder.equal(guide.get(Guide_.lastName), filter.getLastName())));
        }
        query.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
        //Run
        return getEntityManager().createQuery(query).getResultList();
    }
}
