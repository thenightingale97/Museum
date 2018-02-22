package com.museum.repository.impl;


import com.museum.entity.Hall;
import com.museum.repository.AbstractRepository;
import com.museum.repository.HallRepository;
import org.springframework.stereotype.Repository;

@Repository
public class HallRepositoryImpl extends AbstractRepository<Hall, Integer> implements HallRepository {

}
