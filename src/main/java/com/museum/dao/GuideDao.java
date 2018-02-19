package com.museum.dao;

import java.util.List;

import com.museum.entity.Guide;

public interface GuideDao {
	
	void save(Guide guide);
	void update(Guide guide);
	void delete(int id);
	Guide find(int id);
	List<Guide> findAll();
}
