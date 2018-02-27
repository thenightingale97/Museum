package com.museum.repository.impl;


import com.museum.entity.Showpiece;
import com.museum.entity.ShowpieceMaterial;
import com.museum.entity.ShowpieceTechnique;
import com.museum.repository.AbstractRepository;
import com.museum.repository.ShowpieceRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ShowpieceRepositoryImpl extends AbstractRepository<Showpiece, Integer> implements ShowpieceRepository {
    
    /**
     * Task 2.
     */
    @Override
    public List<Showpiece> findAllByAuthor(int authorId) {
        String sql = "SELECT showpiece FROM Showpiece showpiece WHERE showpiece.author.id = ?1";
        TypedQuery<Showpiece> query = getEntityManager().createQuery(sql, Showpiece.class);
        query.setParameter(1, authorId);
        return query.getResultList();
    }
    
    /**
     * Task 3.
     */
    @Override
    public List<Showpiece> findAllByGuardian(int guardianId) {
        String sql = "SELECT showpiece FROM Showpiece showpiece WHERE showpiece.hall.guardian.id = ?1";
        TypedQuery<Showpiece> query = getEntityManager().createQuery(sql, Showpiece.class);
        query.setParameter(1, guardianId);
        return query.getResultList();
    }
    
    /**
     * Task 4.
     */
    @Override
    public List<Showpiece> findAllByHall(int hallId) {
        String sql = "SELECT showpiece FROM Showpiece showpiece WHERE showpiece.hall.id = ?1";
        TypedQuery<Showpiece> query = getEntityManager().createQuery(sql, Showpiece.class);
        query.setParameter(1, hallId);
        return query.getResultList();
    }
    
    /**
     * Task 8.1
     */
    @Override
    public Map<ShowpieceTechnique, Long> getStatisticByTechnique() {
        String sql = "SELECT showpiece.technique, COUNT(showpiece) FROM Showpiece showpiece GROUP BY showpiece.technique";
        TypedQuery<Object[]> query = getEntityManager().createQuery(sql, Object[].class);
        Map<ShowpieceTechnique, Long> result = new HashMap<>();
        for (Object[] objects : query.getResultList()) {
            result.put((ShowpieceTechnique) objects[0], (Long) objects[1]);
        }
        return result;
    }
    
    /**
     * Task 8.2
     */
    @Override
    public Map<ShowpieceMaterial, Long> getStatisticByMaterial() {
        String sql = "SELECT showpiece.material, COUNT(showpiece) FROM Showpiece showpiece GROUP BY showpiece.material";
        TypedQuery<Object[]> query = getEntityManager().createQuery(sql, Object[].class);
        Map<ShowpieceMaterial, Long> result = new HashMap<>();
        for (Object[] objects : query.getResultList()) {
            result.put((ShowpieceMaterial) objects[0], (Long) objects[1]);
        }
        return result;
    }
    
    @Override
    public List<Showpiece> findAllByIds(List<Integer> showpieceIds) {
        String sql = "SELECT showpiece FROM Showpiece showpiece WHERE (showpiece.id IN (:showpieceIds))";
        TypedQuery<Showpiece> query = getEntityManager().createQuery(sql, Showpiece.class);
        query.setParameter("showpieceIds", showpieceIds);
        return query.getResultList();
    }
}
