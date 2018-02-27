package com.museum.service.impl;

import com.museum.entity.Event;
import com.museum.entity.Guide;
import com.museum.repository.EventRepository;
import com.museum.repository.GuideRepository;
import com.museum.service.AbstractService;
import com.museum.service.EventService;
import com.museum.service.impl.util.Validations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventServiceImpl extends AbstractService<Event, Integer, EventRepository> implements EventService {
    
    @Autowired
    private EventRepository repository;
    
    @Autowired
    private GuideRepository guideRepository;
    
    @Override
    public EventRepository getRepository() {
        return repository;
    }

    @Override
    public List<Event> findAllByPeriod(LocalDateTime fromTime, LocalDateTime toTime) {
        Validations.period(fromTime, toTime);
        return getRepository().findAllByPeriod(fromTime, toTime);
    }
    
    @Override
    public Long getAmountByPeriod(LocalDateTime fromTime, LocalDateTime toTime) {
        Validations.period(fromTime, toTime);
        return getRepository().getAmountByPeriod(fromTime, toTime);
    }
    
    @Override
    public Long getAmountByGuide(Guide guide) {
        Validations.entity(guideRepository, guide, "guide");
        return getRepository().getAmountByGuide(guide);
    }
    
    @Override
    public Long getAmountByGuideAndPeriod(Guide guide, LocalDateTime fromTime, LocalDateTime toTime) {
        Validations.period(fromTime, toTime);
        Validations.entity(guideRepository, guide, "guide");
        return getRepository().getAmountByPeriodAndGuide(guide, fromTime, toTime);
    }

    @Override
    public List<Event> findAllUpcomingOrderedByDate(int limit) {
        return getRepository().findAllUpcomingOrderedByDate(limit);
    }
    
    @Override
    public List<Event> findAllByFromTime(LocalDateTime fromTime) {
        return getRepository().findAllByFromTime(fromTime);
    }
    
    @Override
    public List<Event> findAllByToTime(LocalDateTime toTime) {
        return getRepository().findAllByToTime(toTime);
    }
}
