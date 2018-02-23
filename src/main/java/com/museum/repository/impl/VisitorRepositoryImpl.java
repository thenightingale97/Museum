package com.museum.repository.impl;

import com.museum.entity.Visitor;
import com.museum.repository.AbstractRepository;
import com.museum.repository.VisitorRepository;
import org.springframework.stereotype.Repository;

@Repository
public class VisitorRepositoryImpl extends AbstractRepository<Visitor, Integer> implements VisitorRepository {
}
