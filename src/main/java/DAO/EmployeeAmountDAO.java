package DAO;

import entity.EmployeeAmount;
import entity.EmployeeAmountID;

import javax.persistence.EntityManager;

public class EmployeeAmountDAO extends AbstractCRUDDAO<EmployeeAmount, EmployeeAmountID>{
    public EmployeeAmountDAO(EntityManager entityManager) {
        super(entityManager, EmployeeAmount.class);
    }
}
