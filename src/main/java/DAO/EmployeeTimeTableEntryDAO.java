package DAO;

import entity.EmployeeTimesheetEntry;

import javax.persistence.EntityManager;

public class EmployeeTimeTableEntryDAO extends AbstractCRUDDAO<EmployeeTimesheetEntry, Integer>{
    public EmployeeTimeTableEntryDAO(EntityManager entityManager) {
        super(entityManager, EmployeeTimesheetEntry.class);
    }
}
