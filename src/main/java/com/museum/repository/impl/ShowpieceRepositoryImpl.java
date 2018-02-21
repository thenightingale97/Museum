package com.museum.repository.impl;


import com.museum.entity.Showpiece;
import com.museum.repository.AbstractRepository;
import com.museum.repository.ShowpieceRepository;

import javax.persistence.TypedQuery;
import java.util.List;


public class ShowpieceRepositoryImpl extends AbstractRepository<Showpiece, Integer> implements ShowpieceRepository {
    
    /**
     * Task 2.
     *
     * @param authorId - id of some Author
     * @return list of showpieces belongs to some author
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
     * SELECT showpiece.name, hall.name FROM showpiece JOIN hall ON 
     * showpiece.hall_id = hall.id WHERE hall.name = "hall1 .. ";
     */
    @Override
    public List<Showpiece> getByHall(int id) {
        String sql = "SELECT showpiece FROM Showpiece showpiece JOIN showpiece.hall WHERE showpiece.hall = ?1";
        TypedQuery<Showpiece> query = getEntityManager().createQuery(sql, Showpiece.class);
        return query.getResultList();
    }
}
