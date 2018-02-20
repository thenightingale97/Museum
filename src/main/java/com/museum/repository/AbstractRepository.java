package com.museum.repository;

import com.museum.controller.Controller;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractRepository<E, PK extends Serializable> implements Repository<E, PK> {

    private EntityManager entityManager = Controller.getEntityManagerFactory().createEntityManager();
    private Class<E> entityClass;

    @Override
    public void save(E entity) {
        begin();
        entityManager.persist(entity);
        commit();
    }

    @Override
    public void update(E entity) {
        begin();
        entityManager.merge(entity);
        commit();
    }

    @Override
    public void delete(PK id) {
        begin();
        entityManager.remove(findUntransactional(id));
        commit();
    }

    @Override
    public E find(PK id) {
        begin();
        E entity = findUntransactional(id);
        commit();
        return entity;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<E> findAll() {
        String entityName = getEntityClass().getName();
        begin();
        List<E> entities = entityManager
                .createQuery("SELECT a FROM " + entityName + " a")
                .getResultList();
        commit();
        return entities;
    }

    protected E findUntransactional(PK id) {
        return entityManager.find(getEntityClass(), id);
    }

    protected void begin() {
        entityManager.getTransaction().begin();
    }

    protected void commit() {
        entityManager.getTransaction().commit();
    }

    @Override
    public void close() {
        entityManager.close();
    }

    @SuppressWarnings("unchecked")
    public Class<E> getEntityClass() {
        if (entityClass == null) {
            entityClass = (Class<E>) ((ParameterizedType)
                    getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return entityClass;
    }
}
