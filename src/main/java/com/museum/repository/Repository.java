package com.museum.repository;

import java.io.Serializable;
import java.util.List;

import com.museum.entity.Showpiece;


public interface Repository<E, PK extends Serializable> extends AutoCloseable {

    Class<E> getEntityClass();

    void save(E entity);

    void update(E entity);

    void delete(PK id);

    E find(PK id);

    List<E> findAll();

    void begin();

    void commit();

    @Override
    void close();

}
