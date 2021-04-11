package DAO;

import employee.Employee;

public interface CRUDDAO <T, ID> {
    void create(T entity);
    T read(ID id);
    void update(ID id, T entity);
    void delete(T entity);
}
