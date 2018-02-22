package com.museum.service.impl;

import org.springframework.stereotype.Service;

import com.museum.entity.Author;
import com.museum.repository.AuthorRepository;
import com.museum.repository.impl.AuthorRepositoryImpl;
import com.museum.service.AbstractService;
import com.museum.service.AuthorService;

@Service
public class AuthorServiceImpl extends AbstractService<Author, Integer, AuthorRepository> implements AuthorService {

    public AuthorServiceImpl() {
        super(new AuthorRepositoryImpl());
    }
}
