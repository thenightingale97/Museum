package com.museum.service.impl;

import com.museum.entity.Showpiece;
import com.museum.repository.ShowpieceRepository;
import com.museum.repository.impl.ShowpieceRepositoryImpl;
import com.museum.service.AbstractService;
import com.museum.service.ShowpieceService;

public class ShowpieceServiceImpl extends AbstractService<Showpiece, Integer, ShowpieceRepository> implements ShowpieceService {

    public ShowpieceServiceImpl() {
        super(new ShowpieceRepositoryImpl());
    }
}
