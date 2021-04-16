package DAO;

import entity.ContractLine;
import entity.ShiftLine;
import entity.TimeCode;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.UUID;

public class ShiftLineDAO extends AbstractCRUDDAO<ShiftLine, Integer>{
    public ShiftLineDAO(EntityManager entityManager) {
        super(entityManager, ShiftLine.class);
    }

    public ShiftLine findValidOnDate(String shift_code_id, LocalDate date) {
        String sql =
                "SELECT contract.*, max(start_date) " +
                        "FROM contract_line " +
                        "WHERE contract_id = ?1 AND start_date <= ?2";
        return entityManager
                .createQuery(sql, ShiftLine.class)
                .setParameter(1, shift_code_id)
                .setParameter(2, date)
                .getSingleResult();
    }
}
