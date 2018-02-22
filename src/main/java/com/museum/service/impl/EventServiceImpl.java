package com.museum.service.impl;

import com.museum.entity.Event;
import com.museum.repository.EventRepository;
import com.museum.repository.impl.EventRepositoryImpl;
import com.museum.service.AbstractService;
import com.museum.service.EventService;

import java.time.LocalDateTime;
import java.util.List;

public class EventServiceImpl extends AbstractService<Event, Integer, EventRepository> implements EventService {

    public EventServiceImpl() {
	super(new EventRepositoryImpl());
    }

    @Override
    public List<Event> findByPeriod(LocalDateTime fromTime, LocalDateTime toTime) {
        getRepository().begin();
        List<Event> events = getRepository().findByPeriod(fromTime, toTime);
        getRepository().commit();
        return events;
    }
    
    @Override
    public Long getAmountByPeriod(LocalDateTime fromTime, LocalDateTime toTime) {
        getRepository().begin();
        Long amount = getRepository().getAmountByPeriod(fromTime, toTime);
        getRepository().commit();
        return amount;
    }
    
    @Override
    public Long getAmountByGuide(int guideId) {
        getRepository().begin();
        Long amount = getRepository().getAmountByGuide(guideId);
        getRepository().commit();
        return amount;
    }
    
    @Override
    public Long getAmountByPeriodAndGuide(int guideId, LocalDateTime fromTime, LocalDateTime toTime) {
        getRepository().begin();
        Long amount = getRepository().getAmountByPeriodAndGuide(guideId, fromTime, toTime);
        getRepository().commit();
        return amount;
    }
}
