package com.museum.service.impl;

import java.util.List;

import com.museum.dao.GuardianDao;
import com.museum.dao.impl.GuardianDaoImpl;
import com.museum.entity.Guardian;
import com.museum.service.GuardianService;

public class GuardianServiceImpl implements GuardianService{
	
	private GuardianDao guardianDao = new GuardianDaoImpl();

	@Override
	public void save(Guardian guardian) {
		guardianDao.save(guardian);
	}

	@Override
	public void update(Guardian guardian) {
		guardianDao.update(guardian);
	}

	@Override
	public void delete(int id) {
		guardianDao.delete(id);
	}

	@Override
	public Guardian find(int id) {
		return guardianDao.find(id);
	}

	@Override
	public List<Guardian> findAll() {
		return guardianDao.findAll();
	}
}
