package com.museum.service.impl;

import java.util.List;

import com.museum.dao.AuthorDao;
import com.museum.dao.impl.AuthorDaoImpl;
import com.museum.entity.Author;
import com.museum.service.AuthorService;

public class AuthorServiceImpl implements AuthorService{
	
	private AuthorDao authorDao = new AuthorDaoImpl();

	@Override
	public void save(Author author) {
		authorDao.save(author);
	}

	@Override
	public void update(Author author) {
		authorDao.update(author);
	}

	@Override
	public void delete(int id) {
		authorDao.delete(id);
	}

	@Override
	public Author find(int id) {
		return authorDao.find(id);
	}

	@Override
	public List<Author> findAll() {
		return authorDao.findAll();
	}

	@Override
	public void close() {
		authorDao.close();
	}

}
