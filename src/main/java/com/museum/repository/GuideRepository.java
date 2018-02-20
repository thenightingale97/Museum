package com.museum.repository;

import java.util.List;

import com.museum.entity.Guide;

public interface GuideRepository {
	
	void save(Guide guide);
	void update(Guide guide);
	void delete(int id);
	Guide find(int id);
	List<Guide> findAll();
}
