package com.museum.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.museum.controller.Controller;
import com.museum.dao.GuardianDao;
import com.museum.entity.Guardian;

public class GuardianDaoImpl implements GuardianDao{
	
	private EntityManager em = Controller.getEntityManagerFactory().createEntityManager();
	
	@Override
	public void save(Guardian guardian) {
		em.getTransaction().begin();
		em.persist(guardian);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void update(Guardian guardian) {
		em.getTransaction().begin();
		em.merge(guardian);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void delete(int id) {
		em.getTransaction().begin();
		Guardian guardian = find(id);
		em.remove(guardian);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Guardian find(int id) {
		em.getTransaction().begin();
		Guardian guardian = em.find(Guardian.class, id);
		em.getTransaction().commit();
		em.close();
		return guardian;
	}

	@Override
	public List<Guardian> findAll() {
		em.getTransaction().begin();
		List<Guardian> guardians = em.createQuery("SELECT e FROM Excursion e").getResultList();
		em.getTransaction().commit();
		em.close();
		return guardians;
	}

}
