package com.museum.repository.impl;


import java.util.List;

import javax.persistence.Query;

import com.museum.entity.Guide;
import com.museum.entity.GuidePosition;
import com.museum.repository.AbstractRepository;
import com.museum.repository.GuideRepository;

public class GuideRepositoryImpl extends AbstractRepository<Guide, Integer> implements GuideRepository {

    @SuppressWarnings("unchecked")
    @Override
    public List<Guide> getGuideByPosition(GuidePosition position) {
       Query query = getEntityManager().createQuery("SELECT g FROM Guide g WHERE position = ?1");
       query.setParameter(1, position);
       List<Guide> guides = query.getResultList();
       return guides;
    }
}
