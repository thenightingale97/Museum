package com.museum.repository.impl;


import java.util.List;

import javax.persistence.EntityManager;

import com.museum.controller.Controller;
import com.museum.entity.Guide;
import com.museum.repository.GuideRepository;

public class GuideRepositoryImpl implements GuideRepository{
private EntityManager em = Controller.getEntityManagerFactory().createEntityManager();
	
	@Override
	public void save(Guide guide) {
		em.getTransaction().begin();
		em.persist(guide);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void update(Guide guide) {
		em.getTransaction().begin();
		em.merge(guide);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void delete(int id) {
		em.getTransaction().begin();
		Guide excursion = find(id);
		em.remove(excursion);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Guide find(int id) {
		em.getTransaction().begin();
		Guide guide = em.find(Guide.class, id);
		em.getTransaction().commit();
		em.close();
		return guide;
	}

	@Override
	public List<Guide> findAll() {
		em.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<Guide> guides = em.createQuery("SELECT g FROM Guide g").getResultList();
		em.getTransaction().commit();
		em.close();
		return guides;
	}

}
