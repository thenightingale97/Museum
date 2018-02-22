package com.museum.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import com.museum.entity.Event;
import com.museum.repository.EventRepository;
import com.museum.repository.impl.EventRepositoryImpl;
import com.museum.service.AbstractService;
import com.museum.service.EventService;

public class EventServiceImpl extends AbstractService<Event, Integer, EventRepository> implements EventService {

    public EventServiceImpl() {
	super(new EventRepositoryImpl());
    }

    @Override
    public List<Event> getByPeriod(LocalDateTime fromTime, LocalDateTime toTime) {
        getRepository().begin();
        List<Event> events = getRepository().getByPeriod(fromTime, toTime);
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
}
