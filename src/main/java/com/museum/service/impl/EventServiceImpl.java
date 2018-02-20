package com.museum.service.impl;

import com.museum.entity.Event;
import com.museum.repository.EventRepository;
import com.museum.repository.impl.EventRepositoryImpl;
import com.museum.service.AbstractService;
import com.museum.service.EventService;

public class EventServiceImpl extends AbstractService<Event, Integer, EventRepository> implements EventService {

	protected EventServiceImpl() {
		super(new EventRepositoryImpl());
	}
}
