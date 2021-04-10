package DAO;

import entity.EmployeeAmount;

import javax.persistence.EntityManager;

public class EmployeeAmountDAO extends AbstractCRUDDAO<EmployeeAmount, Integer>{
    public EmployeeAmountDAO(EntityManager entityManager) {
        super(entityManager, EmployeeAmount.class);
    }
}
