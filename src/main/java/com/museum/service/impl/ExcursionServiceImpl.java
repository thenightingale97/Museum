package com.museum.service.impl;

import com.museum.entity.Excursion;
import com.museum.repository.ExcursionRepository;
import com.museum.repository.impl.ExcursionRepositoryImpl;
import com.museum.service.AbstractService;
import com.museum.service.ExcursionService;

public class ExcursionServiceImpl extends AbstractService<Excursion, Integer, ExcursionRepository> implements ExcursionService {

        public ExcursionServiceImpl() {
		super(new ExcursionRepositoryImpl());
	}
}
