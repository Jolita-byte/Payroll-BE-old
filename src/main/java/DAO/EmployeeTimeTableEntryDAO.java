package DAO;

import entity.EmployeeTimeTableEntry;

import javax.persistence.EntityManager;

public class EmployeeTimeTableEntryDAO extends AbstractCRUDDAO<EmployeeTimeTableEntry, Integer>{
    public EmployeeTimeTableEntryDAO(EntityManager entityManager) {
        super(entityManager, EmployeeTimeTableEntry.class);
    }
}
