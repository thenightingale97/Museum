package com.museum.service.impl;

import java.util.List;

import com.museum.dao.AuthorDao;
import com.museum.dao.impl.AuthorDaoImpl;
import com.museum.entity.Author;
import com.museum.service.AuthorService;

public class AuthorServiceImpl implements AuthorService{
	
	AuthorDao authorDao;

	@Override
	public void save(Author author) {
		authorDao = new AuthorDaoImpl();
		authorDao.save(author);
	}

	@Override
	public void update(Author author) {
		authorDao = new AuthorDaoImpl();
		authorDao.update(author);
	}

	@Override
	public void delete(int id) {
		authorDao = new AuthorDaoImpl();
		authorDao.delete(id);
	}

	@Override
	public Author find(int id) {
		authorDao = new AuthorDaoImpl();
		return authorDao.find(id);
	}

	@Override
	public List<Author> findAll() {
		authorDao = new AuthorDaoImpl();
		return authorDao.findAll();
	}

}
