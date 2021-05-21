package lt.Payroll.repository;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lt.Payroll.model.Schedule;
import lt.Payroll.model.SchedulePatternLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface SchedulePatternLineRepository extends JpaRepository<SchedulePatternLine, Long> {
    List<SchedulePatternLine> findAllBySchedule(Schedule schedule);

    //@Query(value = "select spl from SchedulePatternLine spl where spl.schedule.id = :schedule_id and spl.initial_date = '2021-01-04'")
    List<SchedulePatternLine> findAllByScheduleAndInitialDate(Schedule schedule, LocalDate initial_date);

    SchedulePatternLine findFirstByScheduleOrderByInitialDate(Schedule schedule);






/*    public SchedulePatternLineRepository(EntityManager entityManager) {
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
    }*/

}
