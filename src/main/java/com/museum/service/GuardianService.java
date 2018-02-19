package com.museum.service;

import java.util.List;

import com.museum.entity.Guardian;

public interface GuardianService {
	void save(Guardian guardian);
	void update(Guardian guardian);
	void delete(int id);
	Guardian find(int id);
	List<Guardian> findAll();
}
