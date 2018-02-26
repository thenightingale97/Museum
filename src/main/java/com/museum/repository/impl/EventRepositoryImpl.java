package com.museum.repository.impl;

import com.museum.entity.Event;
import com.museum.repository.AbstractRepository;
import com.museum.repository.EventRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class EventRepositoryImpl extends AbstractRepository<Event, Integer> implements EventRepository {
    
    /**
     * Task 7.
     */
    @Override
    public List<Event> findByPeriod(LocalDateTime fromTime, LocalDateTime toTime) {
        String sql = "SELECT event FROM Event event WHERE ?1 <= event.startTime " +
                "AND ?2 >= event.finishTime";
        TypedQuery<Event> query = getEntityManager().createQuery(sql, Event.class);
        query.setParameter(1, fromTime);
        query.setParameter(2, toTime);
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
    public Long getAmountByGuide(int guidId) {
        String sql = "SELECT COUNT(guide) "
                + "FROM Guide guide JOIN guide.events event "
                + "WHERE guide.id = ?1 ";
        TypedQuery<Long> query = getEntityManager().createQuery(sql, Long.class);
        query.setParameter(1, guidId);
        return query.getSingleResult();
    }
    
    /**
     * Task 10.2
     */
    @Override
    public Long getAmountByPeriodAndGuide(int guidId, LocalDateTime fromTime, LocalDateTime toTime) {
        String sql = "SELECT COUNT(guide) "
                + "FROM Guide guide JOIN guide.events event "
                + "WHERE (event.startTime >= ?1 AND event.finishTime <= ?2) "
                + "AND (guide.id = ?3)";
        TypedQuery<Long> query = getEntityManager().createQuery(sql, Long.class);
        query.setParameter(1, fromTime);
        query.setParameter(2, toTime);
        query.setParameter(3, guidId);
        return query.getSingleResult();
    }

    @Override
    public List<Event> findUpcomingEventsOrderedByDate() {
        String sql = "SELECT event FROM Event event ORDER BY event.startTime";
        int upcomigEventsAmount = 3;
        TypedQuery<Event> query = getEntityManager().createQuery(sql, Event.class);
        return query.setFirstResult(0).setMaxResults(upcomigEventsAmount).getResultList();
    }

}
