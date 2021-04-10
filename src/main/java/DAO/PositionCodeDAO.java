package DAO;

import entity.PositionCode;

import javax.persistence.EntityManager;

public class PositionCodeDAO extends AbstractCRUDDAO<PositionCode, String>{
    public PositionCodeDAO(EntityManager entityManager) {
        super(entityManager, PositionCode.class);
    }
}
