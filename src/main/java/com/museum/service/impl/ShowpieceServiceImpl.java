package com.museum.service.impl;

import java.util.List;

import com.museum.entity.Showpiece;
import com.museum.repository.ShowpieceRepository;
import com.museum.repository.impl.ShowpieceRepositoryImpl;
import com.museum.service.AbstractService;
import com.museum.service.ShowpieceService;

public class ShowpieceServiceImpl extends AbstractService<Showpiece, Integer, ShowpieceRepository> implements ShowpieceService {

    public ShowpieceServiceImpl() {
        super(new ShowpieceRepositoryImpl());
    }

    @Override
    public List<Showpiece> getByHall(int hallId) {
        getRepository().begin();
        List<Showpiece> showpieces = getRepository().getByHall(hallId);
        getRepository().commit();
        return showpieces;
    }

    @Override
    public List<Showpiece> getByAuthor(int authorId) {
        getRepository().begin();
        List<Showpiece> showpieces = getRepository().getByAuthor(authorId);
        getRepository().commit();
        return showpieces;
    }

    @Override
    public List<Showpiece> getByGuardian(int guardianId) {
        getRepository().begin();
        List<Showpiece> showpieces = getRepository().getByGuardian(guardianId);
        getRepository().commit();
        return showpieces;
    }
    
}
