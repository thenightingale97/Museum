package com.museum.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.museum.dao.GuideDao;
import com.museum.entity.Guide;

public class GuideDaoImpl implements GuideDao{
	
	
	@Override
	public void add(Guide guide) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
			manager.persist(guide);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}

}
