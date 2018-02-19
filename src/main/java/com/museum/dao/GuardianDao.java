package com.museum.dao;

import java.util.List;

import com.museum.entity.Guardian;

public interface GuardianDao {
	void save(Guardian guardian);
	void update(Guardian guardian);
	void delete(int id);
	Guardian find(int id);
	List<Guardian> findAll();
}
