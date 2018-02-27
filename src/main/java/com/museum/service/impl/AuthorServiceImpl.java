package com.museum.service.impl;

import com.museum.entity.Author;
import com.museum.model.view.AuthorView;
import com.museum.repository.AuthorRepository;
import com.museum.service.AbstractService;
import com.museum.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AuthorServiceImpl extends AbstractService<Author, Integer, AuthorRepository> implements AuthorService {

    @Autowired
    private AuthorRepository repository;

    @Override
    public AuthorRepository getRepository() {
        return repository;
    }

    @Override
    @Transactional
    public void save(AuthorView authorView) {
        Author author = new Author();
        author.setFirstName(authorView.getFirstName());
        author.setLastName(authorView.getLastName());
        getRepository().save(author);
    }
}
