package com.museum.service.impl;

import java.util.List;

import com.museum.dao.GuideDao;
import com.museum.dao.impl.GuideDaoImpl;
import com.museum.entity.Guide;
import com.museum.service.GuideService;

public class GuideServiceImpl implements GuideService{
	
	private GuideDao guideDao = new GuideDaoImpl();
	
	@Override
	public void save(Guide guide) {
		guideDao.save(guide);
	}

	@Override
	public void update(Guide guide) {
		guideDao.update(guide);
	}

	@Override
	public void delete(int id) {
		guideDao.delete(id);
	}

	@Override
	public Guide find(int id) {
		return guideDao.find(id);
	}

	@Override
	public List<Guide> findAll() {
		return guideDao.findAll();
	}
	
}
