package com.museum.service;

import com.museum.repository.Repository;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractService<E, PK extends Serializable, R extends Repository<E, PK>> implements Service<E, PK> {

    private final R repository;

    protected AbstractService(R repository) {
        this.repository = repository;
    }

    @Override
    public void save(E entity) {
        repository.begin();
        repository.save(entity);
        repository.commit();
    }

    @Override
    public void update(E entity) {
        repository.begin();
        repository.update(entity);
        repository.commit();
    }

    @Override
    public void delete(PK primaryKey) {
        repository.begin();
        repository.delete(primaryKey);
        repository.commit();
    }

    @Override
    public E find(PK primaryKey) {
        repository.begin();
        E entity = repository.find(primaryKey);
        repository.commit();
        return entity;
    }

    @Override
    public List<E> findAll() {
        repository.begin();
        List<E> entities = repository.findAll();
        repository.commit();
        return entities;
    }

    @Override
    public R getRepository() {
        return repository;
    }
}
