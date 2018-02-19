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
		em.persist(author);
	}

	@Override
	public void update(Author author) {
		em.merge(author);
	}

	@Override
	public void delete(int id) {
		Author author = find(id);
		em.remove(author);
	}

	@Override
	public Author find(int id) {
		Author author = em.find(Author.class, id);
		return author;
	}

	@Override
	public List<Author> findAll() {
		@SuppressWarnings("unchecked")
		List<Author> authors = em.createQuery("SELECT a FROM Author a").getResultList();
		return authors;
	}

	@Override
	public void begin() {
		em.getTransaction().begin();
	}

	@Override
	public void commit() {
		em.getTransaction().commit();
	}

	@Override
	public void close() {
		em.close();
	}
	
}
