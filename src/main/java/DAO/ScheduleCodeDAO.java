package DAO;

import entity.ScheduleCode;

import javax.persistence.EntityManager;

public class ScheduleCodeDAO extends AbstractCRUDDAO<ScheduleCode, String>{
    public ScheduleCodeDAO(EntityManager entityManager) {
        super(entityManager, ScheduleCode.class);
    }
}
