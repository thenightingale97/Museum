package com.museum.service;

import com.museum.repository.Repository;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractService<E, PK extends Serializable, R extends Repository<E, PK>> implements Service<E, PK> {

    @Override
    @Transactional
    public void save(E entity) {
        getRepository().save(entity);
    }

    @Override
    @Transactional
    public void update(E entity) {
        getRepository().update(entity);
    }

    @Override
    @Transactional
    public void delete(PK primaryKey) {
        getRepository().delete(primaryKey);
    }

    @Override
    public E find(PK primaryKey) {
        return getRepository().find(primaryKey);
    }

    @Override
    public List<E> findAll() {
        return getRepository().findAll();
    }

    @Override
    public int count() {
        return getRepository().count();
    }

    @Override
    public abstract R getRepository();
}
