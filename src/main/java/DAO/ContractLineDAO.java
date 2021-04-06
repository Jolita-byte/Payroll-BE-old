package DAO;

import entity.Contract;
import entity.ContractLine;
import entity.ContractLineID;

import javax.persistence.EntityManager;

public class ContractLineDAO extends AbstractCRUDDAO<ContractLine, ContractLineID> {
    public ContractLineDAO(EntityManager entityManager) {
        super(entityManager, ContractLine.class);
    }
}
