package com.museum.service.impl;

import com.museum.entity.Event;
import com.museum.repository.EventRepository;
import com.museum.service.AbstractService;
import com.museum.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventServiceImpl extends AbstractService<Event, Integer, EventRepository> implements EventService {
    
    @Autowired
    private EventRepository repository;
    
    @Override
    public EventRepository getRepository() {
        return repository;
    }

    @Override
    public List<Event> findAllByPeriod(LocalDateTime fromTime, LocalDateTime toTime) {
        return getRepository().findAllByPeriod(fromTime, toTime);
    }
    
    @Override
    public Long getAmountByPeriod(LocalDateTime fromTime, LocalDateTime toTime) {
        return getRepository().getAmountByPeriod(fromTime, toTime);
    }
    
    @Override
    public Long getAmountByGuide(int guideId) {
        return getRepository().getAmountByGuide(guideId);
    }
    
    @Override
    public Long getAmountByPeriodAndGuide(int guideId, LocalDateTime fromTime, LocalDateTime toTime) {
        return getRepository().getAmountByPeriodAndGuide(guideId, fromTime, toTime);
    }

    @Override
    public List<Event> findAllUpcomingOrderedByDate(int limit) {
        return getRepository().findAllUpcomingOrderedByDate(limit);
    }
}
