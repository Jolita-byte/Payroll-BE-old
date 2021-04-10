package DAO;

import entity.SchedulePatternLine;

import javax.persistence.EntityManager;

public class SchedulePatternLineDAO extends AbstractCRUDDAO<SchedulePatternLine, Integer>{
    public SchedulePatternLineDAO(EntityManager entityManager) {
        super(entityManager, SchedulePatternLine.class);
    }
}
