package com.museum.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.museum.controller.Controller;
import com.museum.entity.Excursion;
import com.museum.repository.ExcursionRepository;

public class ExcursionRepositoryImpl implements ExcursionRepository{
	
	private EntityManager em = Controller.getEntityManagerFactory().createEntityManager();
	
	@Override
	public void save(Excursion excursion) {
		em.getTransaction().begin();
		em.persist(excursion);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void update(Excursion excursion) {
		em.getTransaction().begin();
		em.merge(excursion);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void delete(int id) {
		em.getTransaction().begin();
		Excursion excursion = find(id);
		em.remove(excursion);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Excursion find(int id) {
		em.getTransaction().begin();
		Excursion excursion = em.find(Excursion.class, id);
		em.getTransaction().commit();
		em.close();
		return excursion;
	}

	@Override
	public List<Excursion> findAll() {
		em.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<Excursion> excursions = em.createQuery("SELECT e FROM Excursion e").getResultList();
		em.getTransaction().commit();
		em.close();
		return excursions;
	}

}
