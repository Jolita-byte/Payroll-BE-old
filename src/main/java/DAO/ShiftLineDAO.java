package DAO;

import entity.ShiftLine;
import entity.TimeCode;

import javax.persistence.EntityManager;

public class ShiftLineDAO extends AbstractCRUDDAO<ShiftLine, Integer>{
    public ShiftLineDAO(EntityManager entityManager) {
        super(entityManager, ShiftLine.class);
    }
}
