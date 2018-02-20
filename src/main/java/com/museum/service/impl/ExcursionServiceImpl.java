package com.museum.service.impl;

import java.util.List;

import com.museum.entity.Excursion;
import com.museum.repository.ExcursionRepository;
import com.museum.repository.impl.ExcursionRepositoryImpl;
import com.museum.service.ExcursionService;

public class ExcursionServiceImpl  implements ExcursionService{
	
	private ExcursionRepository excursionDao = new ExcursionRepositoryImpl();
	
	@Override
	public void save(Excursion excursion) {
		excursionDao.save(excursion);
	}

	@Override
	public void update(Excursion excursion) {
		excursionDao.update(excursion);
	}

	@Override
	public void delete(int id) {
		excursionDao.delete(id);
	}

	@Override
	public Excursion find(int id) {
		return excursionDao.find(id);
	}

	@Override
	public List<Excursion> findAll() {
		return excursionDao.findAll();
	}

}
