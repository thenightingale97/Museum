package com.museum.dao;

import java.util.List;

import com.museum.entity.Excursion;

public interface ExcursionDao {
	void save(Excursion excursion);
	void update(Excursion excursion);
	void delete(int id);
	Excursion find(int id);
	List<Excursion> findAll();
}
