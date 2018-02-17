package com.museum.dao;

import java.util.List;

import com.museum.entity.Author;

public interface AuthorDao {
	void save(Author author);
	void update(Author author);
	void delete(int id);
	Author find(int id);
	List<Author> findAll();
}
