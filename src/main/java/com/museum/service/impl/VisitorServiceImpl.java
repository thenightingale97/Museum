package com.museum.service.impl;

import com.museum.entity.Visitor;
import com.museum.repository.VisitorRepository;
import com.museum.service.AbstractService;
import com.museum.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;

public class VisitorServiceImpl extends AbstractService<Visitor, Integer, VisitorRepository> implements VisitorService {

    @Autowired
    private VisitorRepository visitorRepository;

    @Override
    public VisitorRepository getRepository() {
        return visitorRepository;
    }
}
