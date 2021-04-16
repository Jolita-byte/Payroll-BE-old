package DAO;

import entity.ContractLine;
import entity.SchedulePatternLine;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class SchedulePatternLineDAO extends AbstractCRUDDAO<SchedulePatternLine, Integer>{
    public SchedulePatternLineDAO(EntityManager entityManager) {
        super(entityManager, SchedulePatternLine.class);
    }

    public SchedulePatternLine findValidOnDate(String schedule_code_id, LocalDate date) {
        String sql =
                "SELECT contract.*, max(start_date) " +
                        "FROM contract_line " +
                        "WHERE contract_id = ?1 AND start_date <= ?2";
        return entityManager
                .createQuery(sql, SchedulePatternLine.class)
                .setParameter(1, schedule_code_id)
                .setParameter(2, date)
                .getSingleResult();
    }

}
