package DAO;

import entity.Employee;

import javax.persistence.EntityManager;

public abstract class AbstractCRUDDAO<T, ID> implements CRUDDAO<T, ID>{
    protected final EntityManager entityManager;
    private final Class<? extends T> entityClass;

    public AbstractCRUDDAO(EntityManager entityManager, Class<? extends T> entityClass) {
        this.entityManager = entityManager;
        this.entityClass = entityClass;
    }

    @Override
    public T read(ID id) {
        return entityManager.find(entityClass, id);
    }

    @Override
    public void create(T entity) {

    }

    @Override
    public void update(ID integer, T entity) {

    }

    @Override
    public void delete(ID integer) {

    }
}
