package com.museum.repository.impl;


import com.museum.entity.Guide;
import com.museum.entity.GuidePosition;
import com.museum.repository.AbstractRepository;
import com.museum.repository.GuideRepository;

import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;

public class GuideRepositoryImpl extends AbstractRepository<Guide, Integer> implements GuideRepository {
    
    
    /**
     * Task 5.
     * 
     */
    @Override
    public List<Guide> getByPosition(GuidePosition position) {
        String sql = "SELECT guide FROM Guide guide WHERE position = ?1";
        TypedQuery<Guide> query = getEntityManager().createQuery(sql, Guide.class);
        query.setParameter(1, position);
        return query.getResultList();
    }
    
    /**
     * Task 6.
     */
    public List<Guide> getByPeriod(LocalDateTime fromTime, LocalDateTime toTime) {
        String sql = "SELECT guide FROM Guide guide " +
                "WHERE guide NOT IN (" +
                "SELECT guide FROM Guide JOIN guide.events event WHERE " +
                "(event.startTime <= :fromTime AND event.finishTime > :fromTime)" +
                "OR (event.startTime < :toTime AND event.finishTime >= :toTime)\n" +
                "OR (event.startTime >= :fromTime AND event.finishTime <= :toTime))";
        TypedQuery<Guide> query = getEntityManager().createQuery(sql, Guide.class);
        query.setParameter("fromTime", fromTime);
        query.setParameter("toTime", toTime);
        
        List<Guide> resultList = query.getResultList();
        return resultList;
    }
    
    /**
     * Task 10.1
     */
    @Override
    public Long getEventAmount(int guidId) {
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
    public Long getEventAmountByPeriod(int guidId, LocalDateTime fromTime, LocalDateTime toTime) {
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
}
