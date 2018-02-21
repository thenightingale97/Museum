package com.museum.service.impl;

import java.util.List;

import com.museum.entity.Guide;
import com.museum.entity.GuidePosition;
import com.museum.repository.GuideRepository;
import com.museum.repository.impl.GuideRepositoryImpl;
import com.museum.service.AbstractService;
import com.museum.service.GuideService;

public class GuideServiceImpl extends AbstractService<Guide, Integer, GuideRepository> implements GuideService {

    public GuideServiceImpl() {
        super(new GuideRepositoryImpl());
    }

    @Override
    public List<Guide> getGuideByPosition(GuidePosition position) {
        getRepository().begin();
        List<Guide> guides = getRepository().getByPosition(position);
        getRepository().commit();
        return guides;
    }

    @Override
    public Long getEventAmount(int guidId) {
        getRepository().begin();
        Long eventAmount = getRepository().getEventAmount(guidId);
        getRepository().commit();
        return eventAmount;
    }
}
