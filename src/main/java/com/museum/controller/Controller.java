package com.museum.controller;


import java.security.Provider.Service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.museum.dao.AuthorDao;
import com.museum.dao.impl.AuthorDaoImpl;
import com.museum.entity.Author;
import com.museum.service.AuthorService;
import com.museum.service.impl.AuthorServiceImpl;


public class Controller {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
	
	public static void main(String[] args) {	
		AuthorDao authorDao = new AuthorDaoImpl();
		authorDao.commit();
		authorDao.delete(3);
		authorDao.delete(4);
		Author author = new Author();
		author.setFirstName("dsadasa121s");
		author.setLastName("dass");
		authorDao.save(author);
		authorDao.begin();
	}
	
	public static EntityManagerFactory getEntityManagerFactory() {
		return factory;
	}
}
