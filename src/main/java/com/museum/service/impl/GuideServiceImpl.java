package com.museum.service.impl;

import com.museum.entity.Guide;
import com.museum.entity.GuidePosition;
import com.museum.repository.GuideRepository;
import com.museum.service.AbstractService;
import com.museum.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GuideServiceImpl extends AbstractService<Guide, Integer, GuideRepository> implements GuideService {
    
    @Autowired
    private GuideRepository repository;
    
    @Override
    public GuideRepository getRepository() {
        return repository;
    }
    
    @Override
    public List<Guide> getGuideByPosition(GuidePosition position) {
        return getRepository().findByPosition(position);
    }
    
    @Override
    public List<Guide> findByPeriod(LocalDateTime fromTime, LocalDateTime toTime) {
        return getRepository().findByPeriod(fromTime, toTime);
    }
    
    @Override
    public Long getWorkTimeByPeriod(int guidId, LocalDateTime fromTime, LocalDateTime toTime) {
        return getRepository().getWorkTimeByPeriod(guidId, fromTime, toTime);
    }

    @Override
    public Long getWorkTime(int guideId) {
        return getRepository().getWorkTime(guideId);
    }
}
