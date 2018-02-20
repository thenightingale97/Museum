package com.museum.service.impl;

import com.museum.entity.Guardian;
import com.museum.repository.GuardianRepository;
import com.museum.repository.impl.GuardianRepositoryImpl;
import com.museum.service.AbstractService;
import com.museum.service.GuardianService;

public class GuardianServiceImpl extends AbstractService<Guardian, Integer, GuardianRepository> implements GuardianService {

    protected GuardianServiceImpl() {
        super(new GuardianRepositoryImpl());
    }
}
