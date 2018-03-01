package com.museum.repository.impl;


import com.museum.entity.*;
import com.museum.model.filter.ShowpieceFilter;
import com.museum.repository.AbstractRepository;
import com.museum.repository.ShowpieceRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ShowpieceRepositoryImpl extends AbstractRepository<Showpiece, Integer> implements ShowpieceRepository {

    /**
     * Task 2.
     */
    @Override
    public List<Showpiece> findAllByAuthor(Author author) {
        String sql = "SELECT showpiece FROM Showpiece showpiece WHERE showpiece.author.id = :authorId";
        TypedQuery<Showpiece> query = getEntityManager().createQuery(sql, Showpiece.class);
        query.setParameter("authorId", author.getId());
        return query.getResultList();
    }

    /**
     * Task 3.
     */
    @Override
    public List<Showpiece> findAllByGuardian(Guardian guardian) {
        String sql = "SELECT showpiece FROM Showpiece showpiece WHERE showpiece.hall.guardian.id = :guardianId";
        TypedQuery<Showpiece> query = getEntityManager().createQuery(sql, Showpiece.class);
        query.setParameter("guardianId", guardian.getId());
        return query.getResultList();
    }

    /**
     * Task 4.
     */
    @Override
    public List<Showpiece> findAllByHall(Hall hall) {
        String sql = "SELECT showpiece FROM Showpiece showpiece WHERE showpiece.hall.id = :hallId";
        TypedQuery<Showpiece> query = getEntityManager().createQuery(sql, Showpiece.class);
        query.setParameter("hallId", hall.getId());
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
    public List<Showpiece> findAllByFilter(ShowpieceFilter request) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Showpiece> criteria = builder.createQuery(Showpiece.class);
        Root<Showpiece> showpiece = criteria.from(Showpiece.class);
        criteria.select(showpiece);
        List<Predicate> predicates = new ArrayList<>();
        if (request.getAuthorId() != null) {
            predicates.add(builder.and(builder.equal(
                    showpiece.get(Showpiece_.author).get(Author_.id), request.getAuthorId())));
        }
        if (request.getHallId() != null) {
            predicates.add(builder.and(builder.equal(
                    showpiece.get(Showpiece_.hall).get(Hall_.id), request.getHallId())));
        }
        if (request.getGuardianId() != null) {
            predicates.add((builder.and(builder.equal(
                    showpiece.get(Showpiece_.hall).get(Hall_.guardian).get(Guardian_.id), request.getGuardianId()))));
        }
        criteria.where(predicates.toArray(new Predicate[predicates.size()]));

        return getEntityManager().createQuery(criteria).getResultList();
    }

    @Override
    public List<Showpiece> findAllByIds(List<Integer> showpieceIds) {
        String sql = "SELECT showpiece FROM Showpiece showpiece WHERE (showpiece.id IN (:showpieceIds))";
        TypedQuery<Showpiece> query = getEntityManager().createQuery(sql, Showpiece.class);
        query.setParameter("showpieceIds", showpieceIds);
        return query.getResultList();
    }
}
