package com.museum.service.impl;

import com.museum.entity.Showpiece;
import com.museum.entity.ShowpieceMaterial;
import com.museum.entity.ShowpieceTechnique;
import com.museum.repository.ShowpieceRepository;
import com.museum.repository.impl.ShowpieceRepositoryImpl;
import com.museum.service.AbstractService;
import com.museum.service.ShowpieceService;

import java.util.List;
import java.util.Map;

public class ShowpieceServiceImpl extends AbstractService<Showpiece, Integer, ShowpieceRepository> implements ShowpieceService {

    public ShowpieceServiceImpl() {
        super(new ShowpieceRepositoryImpl());
    }

    @Override
    public List<Showpiece> findByHall(int hallId) {
        getRepository().begin();
        List<Showpiece> showpieces = getRepository().findByHall(hallId);
        getRepository().commit();
        return showpieces;
    }

    @Override
    public List<Showpiece> findByAuthor(int authorId) {
        getRepository().begin();
        List<Showpiece> showpieces = getRepository().findByAuthor(authorId);
        getRepository().commit();
        return showpieces;
    }

    @Override
    public List<Showpiece> findByGuardian(int guardianId) {
        getRepository().begin();
        List<Showpiece> showpieces = getRepository().findByGuardian(guardianId);
        getRepository().commit();
        return showpieces;
    }
    
    @Override
    public Map<ShowpieceTechnique, Long> getStatisticByTechnique() {
        getRepository().begin();
        Map<ShowpieceTechnique, Long> statisticByTechnique = getRepository().getStatisticByTechnique();
        getRepository().commit();
        return statisticByTechnique;
    }
    
    @Override
    public Map<ShowpieceMaterial, Long> getStatisticByMaterial() {
        getRepository().begin();
        Map<ShowpieceMaterial, Long> statisticByMaterial = getRepository().getStatisticByMaterial();
        getRepository().commit();
        return statisticByMaterial;
    }
}
