package DAO;

import entity.AmountCode;

import javax.persistence.EntityManager;

public class AmountCodeDAO extends AbstractCRUDDAO<AmountCode, String>{
    public AmountCodeDAO(EntityManager entityManager) {
        super(entityManager, AmountCode.class);
    }
}
