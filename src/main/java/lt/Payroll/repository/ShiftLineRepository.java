package lt.Payroll.repository;

import lt.Payroll.model.Shift;
import lt.Payroll.model.ShiftLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ShiftLineRepository extends JpaRepository<ShiftLine, Long> {
    List<ShiftLine> findAllByShift(Shift shift);




//    public ShiftLineRepository(EntityManager entityManager) {
//        super(entityManager, ShiftLine.class);
//    }
//
//    public ShiftLine findValidOnDate(String shift_code_id, LocalDate date) {
//        String sql =
//                "SELECT contract.*, max(start_date) " +
//                        "FROM contract_line " +
//                        "WHERE contract_id = ?1 AND start_date <= ?2";
//        return entityManager
//                .createQuery(sql, ShiftLine.class)
//                .setParameter(1, shift_code_id)
//                .setParameter(2, date)
//                .getSingleResult();
//    }
}
