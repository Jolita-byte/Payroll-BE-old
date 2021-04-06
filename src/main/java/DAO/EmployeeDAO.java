package DAO;

import entity.Employee;
import javax.persistence.EntityManager;

public class EmployeeDAO extends AbstractCRUDDAO<Employee, Integer> {
    public EmployeeDAO(EntityManager entityManager) {
        super(entityManager, Employee.class);
    }


}
