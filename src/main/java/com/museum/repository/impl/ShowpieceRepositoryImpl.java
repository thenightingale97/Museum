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
        /*
         SELECT showpiece.name, showpiece.type, guardian.firstName, guardian.lastName
         FROM showpiece JOIN hall ON hall_id = hall.id JOIN guardian ON guardian.id = guardian_id WHERE guardian.id = 1;
         */
        String sql = "SELECT showpiece FROM Showpiece showpiece WHERE showpiece.hall.guardian.id = ?1";
        TypedQuery<Showpiece> query = getEntityManager().createQuery(sql, Showpiece.class);
        query.setParameter(1, guardianId);
        return query.getResultList();
    }
}
