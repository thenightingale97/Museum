package com.museum.repository.impl;

import com.museum.entity.Event;
import com.museum.entity.Event_;
import com.museum.entity.Excursion;
import com.museum.entity.Guide;
import com.museum.model.filter.EventFilter;
import com.museum.repository.AbstractRepository;
import com.museum.repository.EventRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EventRepositoryImpl extends AbstractRepository<Event, Integer> implements EventRepository {

    /**
     * Task 7.
     */
    @Override
    public List<Event> findAllByPeriod(LocalDateTime fromTime, LocalDateTime toTime) {
        String sql = "SELECT event FROM Event event WHERE event.startTime >= :fromTime AND event.startTime <= :toTime " +
                "ORDER BY event.startTime";
        TypedQuery<Event> query = getEntityManager().createQuery(sql, Event.class);
        query.setParameter("fromTime", fromTime);
        query.setParameter("toTime", toTime);
        return query.getResultList();
    }

    /**
     * Task 9.
     */
    @Override
    public Long getAmountByPeriod(LocalDateTime fromTime, LocalDateTime toTime) {
        String sql = "SELECT COUNT(event) FROM Event event WHERE event.startTime >= ?1 AND event.startTime <= ?2";
        TypedQuery<Long> query = getEntityManager().createQuery(sql, Long.class);
        query.setParameter(1, fromTime);
        query.setParameter(2, toTime);
        return query.getSingleResult();
    }

    /**
     * Task 10.1
     */
    @Override
    public Long getAmountByGuide(Guide guide) {
        String sql = "SELECT COUNT(guide) "
                + "FROM Guide guide JOIN guide.events event "
                + "WHERE guide.id = :guideId";
        TypedQuery<Long> query = getEntityManager().createQuery(sql, Long.class);
        query.setParameter("guideId", guide.getId());
        return query.getSingleResult();
    }

    /**
     * Task 10.2
     */
    @Override
    public Long getAmountByPeriodAndGuide(Guide guide, LocalDateTime fromTime, LocalDateTime toTime) {
        String sql = "SELECT COUNT(guide) "
                + "FROM Guide guide JOIN guide.events event "
                + "WHERE (event.startTime >= :fromTime AND event.finishTime <= :toTime) "
                + "AND (guide.id = :guideId)";
        TypedQuery<Long> query = getEntityManager().createQuery(sql, Long.class);
        query.setParameter("fromTime", fromTime);
        query.setParameter("toTime", toTime);
        query.setParameter("guideId", guide.getId());
        return query.getSingleResult();
    }

    @Override
    public List<Event> findAllUpcomingOrderedByDate(int limit) {
        String sql = "SELECT event FROM Event event ORDER BY event.startTime";
        TypedQuery<Event> query = getEntityManager().createQuery(sql, Event.class);
        query.setMaxResults(limit);
        return query.getResultList();
    }

    @Override
    public List<Event> findAllByFromTime(LocalDateTime fromTime) {
        String sql = "SELECT event FROM Event event WHERE event.startTime >= :fromTime ORDER BY event.startTime";
        TypedQuery<Event> query = getEntityManager().createQuery(sql, Event.class);
        query.setParameter("fromTime", fromTime);
        return query.getResultList();
    }

    @Override
    public List<Event> findAllByToTime(LocalDateTime toTime) {
        String sql = "SELECT event FROM Event event WHERE event.startTime <= :toTime ORDER BY event.startTime";
        TypedQuery<Event> query = getEntityManager().createQuery(sql, Event.class);
        query.setParameter("toTime", toTime);
        return query.getResultList();
    }

    @Override
    public List<Event> findAllByExcursion(Excursion excursion) {
        String sql = "SELECT event FROM Event event WHERE event.excursion = :excursion ORDER BY event.startTime";
        TypedQuery<Event> query = getEntityManager().createQuery(sql, Event.class);
        query.setParameter("excursion", excursion);
        return query.getResultList();
    }

    @Override
    public List<Event> findAllByFilter(EventFilter filter) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Event> criteria = builder.createQuery(Event.class);

        // From
        Root<Event> event = criteria.from(Event.class);
        // Select
        criteria.select(event);
        // Where
        List<Predicate> predicates = new ArrayList<>();
        if (filter.hasFromDateTime()) {
            predicates.add(builder.and(
                    builder.greaterThanOrEqualTo(event.get(Event_.startTime), filter.getFromDateTime())));
        }
        if (filter.hasToDateTime()) {
            predicates.add(builder.and(
                    builder.lessThanOrEqualTo(event.get(Event_.startTime), filter.getToDateTime())));
        }
        if (filter.hasExcursionId()) {
            predicates.add(builder.and(
                    builder.equal(event.get(Event_.excursion).get(Event_.id), filter.getExcurtionId())));
        }
        criteria.where(predicates.toArray(new Predicate[predicates.size()]));
        //Run
        return getEntityManager().createQuery(criteria).getResultList();
    }
}
