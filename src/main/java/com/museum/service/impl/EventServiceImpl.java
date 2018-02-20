package com.museum.service.impl;

import java.util.List;

import com.museum.entity.Event;
import com.museum.repository.EventRepository;
import com.museum.repository.impl.EventRepositoryImpl;
import com.museum.service.EventService;

public class EventServiceImpl implements EventService{
	
	private EventRepository eventDao = new EventRepositoryImpl();
	
	@Override
	public void save(Event event) {
		eventDao.save(event);
	}

	@Override
	public void update(Event event) {
		eventDao.update(event);
	}

	@Override
	public void delete(int id) {
		eventDao.delete(id);
	}

	@Override
	public Event find(int id) {
		return eventDao.find(id);
	}

	@Override
	public List<Event> findAll() {
		return eventDao.findAll();
	}

}
