package DAO;

import entity.EmployeeScheduleEntry;

import javax.persistence.EntityManager;

public class EmployeeScheduleEntryDAO extends AbstractCRUDDAO<EmployeeScheduleEntry, Integer>{
    public EmployeeScheduleEntryDAO(EntityManager entityManager) {
        super(entityManager, EmployeeScheduleEntry.class);
    }
}
