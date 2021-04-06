package DAO;

import entity.Contract;
import entity.Employee;

import javax.persistence.EntityManager;

public class ContractDAO extends AbstractCRUDDAO<Contract, Integer> {
    public ContractDAO(EntityManager entityManager) {
        super(entityManager, Contract.class);
    }
}
