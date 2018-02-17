package com.museum.service;

import java.util.List;

import com.museum.entity.Event;


public interface EventService {
	void save(Event event);
	void update(Event event);
	void delete(int id);
	Event find(int id);
	List<Event> findAll();
}
