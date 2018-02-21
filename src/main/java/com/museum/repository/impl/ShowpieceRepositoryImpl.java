package com.museum.repository.impl;


import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.TypedQuery;

import com.museum.entity.Showpiece;
import com.museum.repository.AbstractRepository;
import com.museum.repository.ShowpieceRepository;


public class ShowpieceRepositoryImpl extends AbstractRepository<Showpiece, Integer> implements ShowpieceRepository {
    
    /**
     * Task 2.
     */
    @Override
    public List<Showpiece> getByAuthor(int authorId) {
        String sql = "SELECT showpiece FROM Showpiece showpiece WHERE showpiece.author.id = ?1";
        TypedQuery<Showpiece> query = getEntityManager().createQuery(sql, Showpiece.class);
        query.setParameter(1, authorId);
        return query.getResultList();
    }
    
    /**
     * Task 3.
     */
    @Override
    public List<Showpiece> getByGuardian(int guardianId) {
        String sql = "SELECT showpiece FROM Showpiece showpiece WHERE showpiece.hall.guardian.id = ?1";
        TypedQuery<Showpiece> query = getEntityManager().createQuery(sql, Showpiece.class);
        query.setParameter(1, guardianId);
        return query.getResultList();
    }
    
    /**
     * Task 4.
     */
    @Override
    public List<Showpiece> getByHall(int hallId) {
        String sql = "SELECT showpiece FROM Showpiece showpiece WHERE showpiece.hall.id = ?1";
        TypedQuery<Showpiece> query = getEntityManager().createQuery(sql, Showpiece.class);
        query.setParameter(1, hallId);
        return query.getResultList();
    }
    
    /**
     * Task 9.
     * ELECT COUNT(*) FROM event WHERE startTime >= "2018-02-20" AND startTime <= "2018-02-21";
     */
    @Override
    public Integer getAmountByPeriod(LocalDateTime fromTime, LocalDateTime toTime) {
        String sql = "SELECT COUNT(event) FROM Event event WHERE event.startTime >= ?1 AND event.startTime <= ?2";
        TypedQuery<Integer> query = getEntityManager().createQuery(sql, Integer.class);
        return query.getSingleResult();
    }
}
