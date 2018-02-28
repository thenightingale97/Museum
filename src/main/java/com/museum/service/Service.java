package com.museum.service;

import com.museum.repository.Repository;

import java.io.Serializable;
import java.util.List;

public interface Service<E, PK extends Serializable> {

    void save(E entity);

    void update(E entity);

    void delete(PK primaryKey);

    E find(PK primaryKey);

    List<E> findAll();
    
    int count();

    Repository<E, PK> getRepository();

}
