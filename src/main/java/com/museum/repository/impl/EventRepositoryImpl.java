package com.museum.repository.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.TypedQuery;

import com.museum.entity.Event;
import com.museum.repository.AbstractRepository;
import com.museum.repository.EventRepository;

public class EventRepositoryImpl extends AbstractRepository<Event, Integer> implements EventRepository {

    /**
     * Task 7.
     * Select event.id, startTime, finishTime, excursion.name  from event   join excursion
      on excursion.id   = event.excursion_id where where "2018-02-20" <= startTime 
      AND "2018-02-21" >= finishTime;
     */
    @Override
    public List<Event> getByPeriod(LocalDateTime fromTime, LocalDateTime toTime) {
        String sql = "SELECT event FROM Event event WHERE ?1 <= event.startTime " + 
            "AND ?2 >= event.finishTime";
        TypedQuery<Event> query = getEntityManager().createQuery(sql, Event.class);
        query.setParameter(1, fromTime);
        query.setParameter(2, toTime);
        return query.getResultList();
    }

}
