package com.museum.repository.impl;


import java.util.List;

import javax.persistence.TypedQuery;

import com.museum.entity.Guide;
import com.museum.entity.GuidePosition;
import com.museum.repository.AbstractRepository;
import com.museum.repository.GuideRepository;

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
}
