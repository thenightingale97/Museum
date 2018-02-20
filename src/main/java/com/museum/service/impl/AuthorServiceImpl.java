package com.museum.service.impl;

import java.util.List;

import com.museum.entity.Author;
import com.museum.repository.AuthorRepository;
import com.museum.repository.impl.AuthorRepositoryImpl;
import com.museum.service.AuthorService;

public class AuthorServiceImpl implements AuthorService{
	
	private AuthorRepository authorDao = new AuthorRepositoryImpl();

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

}
