package com.museum.service.impl;

import com.museum.entity.Showpiece;
import com.museum.entity.ShowpieceMaterial;
import com.museum.entity.ShowpieceTechnique;
import com.museum.repository.ShowpieceRepository;
import com.museum.service.AbstractService;
import com.museum.service.ShowpieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShowpieceServiceImpl extends AbstractService<Showpiece, Integer, ShowpieceRepository> implements ShowpieceService {

    @Autowired
    private ShowpieceRepository repository;

    @Override
    public ShowpieceRepository getRepository() {
        return repository;
    }

    @Override
    public List<Showpiece> findByHall(int hallId) {
        return getRepository().findByHall(hallId);
    }

    @Override
    public List<Showpiece> findByAuthor(int authorId) {
        return getRepository().findByAuthor(authorId);
    }

    @Override
    public List<Showpiece> findByGuardian(int guardianId) {
        return getRepository().findByGuardian(guardianId);
    }

    @Override
    public Map<ShowpieceTechnique, Long> getStatisticByTechnique() {
        return getRepository().getStatisticByTechnique();
    }

    @Override
    public Map<ShowpieceMaterial, Long> getStatisticByMaterial() {
        return getRepository().getStatisticByMaterial();
    }

    @Override
    public Showpiece getRandomShowpiece() {
        Random random = new Random();
        int maxSize = getRepository().findAll().size() - 1;
        Showpiece randomShowpiece = find(random.nextInt(maxSize) + 1);
        return randomShowpiece ;
    }
}