package com.museum.service.impl;

import com.museum.entity.Hall;
import com.museum.model.view.HallView;
import com.museum.repository.GuardianRepository;
import com.museum.repository.HallRepository;
import com.museum.service.AbstractService;
import com.museum.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class HallServiceImpl extends AbstractService<Hall, Integer, HallRepository> implements HallService {
    
    @Autowired
    private HallRepository repository;

    @Autowired
    private GuardianRepository guardianRepository;

    @Override
    public HallRepository getRepository() {
        return repository;
    }

    @Override
    @Transactional
    public void update(HallView hallView) {
        Hall hall = new Hall();
        hall.setId(hallView.getId());
        hall.setGuardian(guardianRepository.find(hallView.getGuardian()));
        hall.setName(hallView.getName());
        repository.update(hall);
    }
}
