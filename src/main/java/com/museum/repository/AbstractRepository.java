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
        entityManager.persist(entity);
    }

    @Override
    public void update(E entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(PK id) {
        entityManager.remove(find(id));
    }

    @Override
    public E find(PK id) {
        return entityManager.find(getEntityClass(), id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<E> findAll() {
        String entityName = getEntityClass().getName();
        begin();
        List<E> entities = entityManager
                .createQuery("SELECT entity FROM " + entityName + " entity")
                .getResultList();
        commit();
        return entities;
    }

    @Override
    public void close() {
        entityManager.close();
    }

    @Override
    public void begin() {
        entityManager.getTransaction().begin();
    }

    @Override
    public void commit() {
        entityManager.getTransaction().commit();
    }

    protected EntityManager getEntityManager() {
        return entityManager;
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
