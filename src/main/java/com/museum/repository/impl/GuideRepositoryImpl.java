package com.museum.repository.impl;


import com.museum.entity.Guide;
import com.museum.entity.GuidePosition;
import com.museum.repository.AbstractRepository;
import com.museum.repository.GuideRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.time.LocalDateTime;
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
                "WHERE (event.startTime <= :fromTime AND event.finishTime > :fromTime) "
                + "OR (event.startTime < :toTime AND event.finishTime >= :toTime) "
                + "OR (event.startTime >= :fromTime AND event.finishTime <= :toTime))";
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
}
