package com.museum.service.impl;

import org.springframework.stereotype.Service;

import com.museum.entity.Guardian;
import com.museum.repository.GuardianRepository;
import com.museum.repository.impl.GuardianRepositoryImpl;
import com.museum.service.AbstractService;
import com.museum.service.GuardianService;

@Service
public class GuardianServiceImpl extends AbstractService<Guardian, Integer, GuardianRepository> implements GuardianService {

    public GuardianServiceImpl() {
        super(new GuardianRepositoryImpl());
    }
}
