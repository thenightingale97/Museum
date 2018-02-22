package com.museum.repository.impl;

import com.museum.entity.Excursion;
import com.museum.repository.AbstractRepository;
import com.museum.repository.ExcursionRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ExcursionRepositoryImpl extends AbstractRepository<Excursion, Integer> implements ExcursionRepository {

}
