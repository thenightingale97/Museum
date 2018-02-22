package com.museum.service.impl;

import com.museum.entity.Excursion;
import com.museum.repository.ExcursionRepository;
import com.museum.service.AbstractService;
import com.museum.service.ExcursionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExcursionServiceImpl extends AbstractService<Excursion, Integer, ExcursionRepository> implements ExcursionService {
	
	@Autowired
	private ExcursionRepository repository;
	
	@Override
	public ExcursionRepository getRepository() {
		return repository;
	}
}
