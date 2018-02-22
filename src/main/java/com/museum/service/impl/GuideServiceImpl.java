package com.museum.service.impl;

import com.museum.entity.Guide;
import com.museum.entity.GuidePosition;
import com.museum.repository.GuideRepository;
import com.museum.repository.impl.GuideRepositoryImpl;
import com.museum.service.AbstractService;
import com.museum.service.GuideService;

import java.time.LocalDateTime;
import java.util.List;

public class GuideServiceImpl extends AbstractService<Guide, Integer, GuideRepository> implements GuideService {

    public GuideServiceImpl() {
        super(new GuideRepositoryImpl());
    }

    @Override
    public List<Guide> getGuideByPosition(GuidePosition position) {
        getRepository().begin();
        List<Guide> guides = getRepository().findByPosition(position);
        getRepository().commit();
        return guides;
    }
    
    @Override
    public List<Guide> findByPeriod(LocalDateTime fromTime, LocalDateTime toTime) {
        getRepository().begin();
        List<Guide> guides = getRepository().findByPeriod(fromTime, toTime);
        getRepository().commit();
        return guides;
    }
    
    @Override
    public Long getWorkTimeByPeriod(int guidId, LocalDateTime fromTime, LocalDateTime toTime) {
        getRepository().begin();
        Long eventAmount = getRepository().getWorkTimeByPeriod(guidId, fromTime, toTime);
        getRepository().commit();
        return eventAmount;
    }

    @Override
    public Long getWorkTime(int guideId) {
        getRepository().begin();
        Long workTime = getRepository().getWorkTime(guideId);
        getRepository().commit();
        return workTime;
    }
}
