package com.museum.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.museum.controller.Controller;
import com.museum.entity.Event;
import com.museum.repository.EventRepository;

public class EventRepositoryImpl implements EventRepository{

private EntityManager em = Controller.getEntityManagerFactory().createEntityManager();
	
	@Override
	public void save(Event event) {
		em.getTransaction().begin();
		em.persist(event);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void update(Event event) {
		em.getTransaction().begin();
		em.merge(event);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void delete(int id) {
		em.getTransaction().begin();
		Event event = find(id);
		em.remove(event);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Event find(int id) {
		em.getTransaction().begin();
		Event event = em.find(Event.class, id);
		em.getTransaction().commit();
		em.close();
		return event;
	}

	@Override
	public List<Event> findAll() {
		em.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<Event> events = em.createQuery("SELECT e FROM Event e").getResultList();
		em.getTransaction().commit();
		em.close();
		return events;
	}

}
