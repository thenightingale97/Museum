package com.museum.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractRepository<E, PK extends Serializable> implements Repository<E, PK> {
    
    @PersistenceContext
    private EntityManager entityManager;
    
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
    public List<E> findAll() {
        String entityName = getEntityClass().getName();
        return entityManager
                .createQuery("SELECT entity FROM " + entityName + " entity", getEntityClass())
                .getResultList();
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
