package com.museum.service.impl;

import org.springframework.stereotype.Service;

import com.museum.entity.Hall;
import com.museum.repository.HallRepository;
import com.museum.repository.impl.HallRepositoryImpl;
import com.museum.service.AbstractService;
import com.museum.service.HallService;

@Service
public class HallServiceImpl extends AbstractService<Hall, Integer, HallRepository> implements HallService {

    public HallServiceImpl() {
        super(new HallRepositoryImpl());
    }
}
