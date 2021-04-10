package DAO;

import entity.TimeCode;

import javax.persistence.EntityManager;

public class TimeCodeDAO extends AbstractCRUDDAO<TimeCode, String>{
    public TimeCodeDAO(EntityManager entityManager) {
        super(entityManager, TimeCode.class);
    }
}
