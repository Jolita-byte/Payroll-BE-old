package DAO;

import entity.ContractLine;
import entity.ContractLineID;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

public class ContractLineDAO extends AbstractCRUDDAO<ContractLine, ContractLineID> {
    public ContractLineDAO(EntityManager entityManager) {
        super(entityManager, ContractLine.class);
    }

    public List<ContractLine> findValidOnDate(Integer contract_id, LocalDate date) {
//        String sql = "FROM contract_line " +
//                "WHERE contract_id = 1 AND start_date <= 2021-01-01 " +
//                "ORDER BY start_date desc";
        String sql = "FROM ContractLine";
        return entityManager
                .createQuery(sql, ContractLine.class)
                //.setParameter("C", contract_id)
                //.setParameter("D", date)
        .getResultList();
                //.getSingleResult();
    }
}
