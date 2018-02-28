package com.museum.repository;

import java.io.Serializable;
import java.util.List;


public interface Repository<E, PK extends Serializable> {

    Class<E> getEntityClass();

    void save(E entity);

    void update(E entity);

    void delete(PK id);

    E find(PK id);

    List<E> findAll();

    boolean exists(PK id);

    int count();
}
