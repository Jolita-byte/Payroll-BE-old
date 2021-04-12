package DAO;

import entity.ShiftLine;
import entity.TimeCode;

import javax.persistence.EntityManager;
import java.util.UUID;

public class ShiftLineDAO extends AbstractCRUDDAO<ShiftLine, Integer>{
    public ShiftLineDAO(EntityManager entityManager) {
        super(entityManager, ShiftLine.class);
    }
}
