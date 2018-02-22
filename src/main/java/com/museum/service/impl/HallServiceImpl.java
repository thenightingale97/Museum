package com.museum.service.impl;

import com.museum.entity.Hall;
import com.museum.repository.HallRepository;
import com.museum.service.AbstractService;
import com.museum.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HallServiceImpl extends AbstractService<Hall, Integer, HallRepository> implements HallService {
    
    @Autowired
    private HallRepository repository;
    
    @Override
    public HallRepository getRepository() {
        return repository;
    }
}
