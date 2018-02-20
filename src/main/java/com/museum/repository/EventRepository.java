package com.museum.repository;

import java.util.List;

import com.museum.entity.Event;

public interface EventRepository {
	void save(Event event);
	void update(Event event);
	void delete(int id);
	Event find(int id);
	List<Event> findAll();
}
