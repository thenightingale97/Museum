package com.museum.service.impl;

import com.museum.entity.Author;
import com.museum.repository.AuthorRepository;
import com.museum.service.AbstractService;
import com.museum.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl extends AbstractService<Author, Integer, AuthorRepository> implements AuthorService {

    @Autowired
    private AuthorRepository repository;

    @Override
    public AuthorRepository getRepository() {
        return repository;
    }

}
