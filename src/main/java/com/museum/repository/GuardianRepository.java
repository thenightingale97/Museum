package com.museum.repository;

import java.util.List;

import com.museum.entity.Guardian;

public interface GuardianRepository {
	void save(Guardian guardian);
	void update(Guardian guardian);
	void delete(int id);
	Guardian find(int id);
	List<Guardian> findAll();
}
