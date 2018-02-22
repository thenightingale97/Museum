package com.museum.repository.impl;

import com.museum.entity.Author;
import com.museum.repository.AbstractRepository;
import com.museum.repository.AuthorRepository;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorRepositoryImpl extends AbstractRepository<Author, Integer> implements AuthorRepository {

}
