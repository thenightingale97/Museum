package com.museum.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;


import com.museum.controller.Controller;
import com.museum.dao.AuthorDao;
import com.museum.entity.Author;

public class AuthorDaoImpl implements AuthorDao{
	
	private EntityManager em = Controller.getEntityManagerFactory().createEntityManager();
	
	@Override
	public void save(Author author) {
		em.getTransaction().begin();
		em.persist(author);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void update(Author author) {
		em.getTransaction().begin();
		em.merge(author);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void delete(int id) {
		em.getTransaction().begin();
		Author author = find(id);
		em.remove(author);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Author find(int id) {
		em.getTransaction().begin();
		Author author = em.find(Author.class, id);
		em.getTransaction().commit();
		em.close();
		return author;
	}

	@Override
	public List<Author> findAll() {
		em.getTransaction().begin();
		List<Author> author = em.createQuery("SELECT a FROM Author a").getResultList();
		em.getTransaction().commit();
		em.close();
		return author;
	}
	
}
