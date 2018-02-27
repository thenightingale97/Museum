package com.museum.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
        String sql = "SELECT entity FROM " + entityName + " entity";
        return entityManager
                .createQuery(sql, getEntityClass())
                .getResultList();
    }
    
    @Override
    public int count() {
        String entityName = getEntityClass().getName();
        String sql = "SELECT COUNT(entity) FROM " + entityName + " entity";
        TypedQuery<Long> query = entityManager.createQuery(sql, Long.class);
        return query.getSingleResult().intValue();
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
    
    @Override
    public boolean exists(PK id) {
        String entityName = getEntityClass().getName();
        String sql = "SELECT COUNT(entity) FROM " + entityName + " entity WHERE entity.id = :id";
        TypedQuery<Long> query = entityManager.createQuery(sql, Long.class);
        query.setParameter("id", id);
        return query.getSingleResult() > 0;
    }
}
