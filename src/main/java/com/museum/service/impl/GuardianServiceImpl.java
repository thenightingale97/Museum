package com.museum.service.impl;

import com.museum.entity.Guardian;
import com.museum.repository.GuardianRepository;
import com.museum.service.AbstractService;
import com.museum.service.GuardianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuardianServiceImpl extends AbstractService<Guardian, Integer, GuardianRepository> implements GuardianService {
    
    @Autowired
    private GuardianRepository repository;
    
    @Override
    public GuardianRepository getRepository() {
        return repository;
    }
}
