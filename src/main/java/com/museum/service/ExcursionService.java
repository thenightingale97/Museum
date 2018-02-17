package com.museum.service;

import java.util.List;

import com.museum.entity.Excursion;

public interface ExcursionService {
	void save(Excursion excursion);
	void update(Excursion excursion);
	void delete(int id);
	Excursion find(int id);
	List<Excursion> findAll();
}
