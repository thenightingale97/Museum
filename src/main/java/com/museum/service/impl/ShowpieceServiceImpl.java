package com.museum.service.impl;

import com.museum.entity.*;
import com.museum.model.request.ShowpieceRequest;
import com.museum.repository.AuthorRepository;
import com.museum.repository.GuardianRepository;
import com.museum.repository.HallRepository;
import com.museum.repository.ShowpieceRepository;
import com.museum.service.AbstractService;
import com.museum.service.ShowpieceService;
import com.museum.service.impl.util.Validations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class ShowpieceServiceImpl extends AbstractService<Showpiece, Integer, ShowpieceRepository> implements ShowpieceService {

    @Autowired
    private ShowpieceRepository repository;
    
    @Autowired
    private HallRepository hallRepository;
    
    @Autowired
    private AuthorRepository authorRepository;
    
    @Autowired
    private GuardianRepository guardianRepository;

    @Override
    public ShowpieceRepository getRepository() {
        return repository;
    }

    @Override
    public List<Showpiece> findAllByHall(Hall hall) {
        Validations.entity(hallRepository, hall, "hall");
        return getRepository().findAllByHall(hall);
    }

    @Override
    public List<Showpiece> findAllByAuthor(Author author) {
        Validations.entity(authorRepository, author, "author");
        return getRepository().findAllByAuthor(author);
    }

    @Override
    public List<Showpiece> findAllByGuardian(Guardian guardian) {
        Validations.entity(guardianRepository, guardian, "guardian");
        return getRepository().findAllByGuardian(guardian);
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
    public List<Showpiece> findAllByRandom(int count) {
        final int showpieceCount = getRepository().count();
        Random random = new Random();
        List<Integer> showpieceIds = random
                .ints(count, 1, showpieceCount + 1)
                .boxed()
                .collect(Collectors.toList());
        return getRepository().findAllByIds(showpieceIds);
    }

    @Override
    @Transactional
    public void update(ShowpieceRequest showpieceView) {
        Showpiece showpiece = new Showpiece();
        showpiece.setAuthor(authorRepository.find(showpieceView.getAuthor()));
        showpiece.setHall(hallRepository.find(showpieceView.getHall()));
        showpiece.setDescription(showpieceView.getDescription());
        showpiece.setImageUrl(showpieceView.getImageUrl());
        showpiece.setTechnique(showpieceView.getTechnique());
        showpiece.setMaterial(showpieceView.getMaterial());
        showpiece.setName(showpieceView.getName());
        showpiece.setId(showpieceView.getId());
        repository.update(showpiece);
    }
}