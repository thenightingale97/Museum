package com.museum.service.impl;

import com.museum.entity.*;
import com.museum.repository.ShowpieceRepository;
import com.museum.service.AbstractService;
import com.museum.service.ShowpieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class ShowpieceServiceImpl extends AbstractService<Showpiece, Integer, ShowpieceRepository> implements ShowpieceService {

    @Autowired
    private ShowpieceRepository repository;

    @Override
    public ShowpieceRepository getRepository() {
        return repository;
    }

    @Override
    public List<Showpiece> findAllByHall(Hall hall) {
        return getRepository().findAllByHall(hall);
    }

    @Override
    public List<Showpiece> findAllByAuthor(Author author) {
        return getRepository().findAllByAuthor(author);
    }

    @Override
    public List<Showpiece> findAllByGuardian(Guardian guardian) {
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
}