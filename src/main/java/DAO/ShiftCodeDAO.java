package DAO;

import entity.ShiftCode;

import javax.persistence.EntityManager;

public class ShiftCodeDAO extends AbstractCRUDDAO<ShiftCode, String>{
    public ShiftCodeDAO(EntityManager entityManager) {
        super(entityManager, ShiftCode.class);
    }
}
