package lt.Payroll.repository;

import lt.Payroll.model.EmployeeScheduleEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public interface EmployeeScheduleEntryRepository extends JpaRepository<EmployeeScheduleEntry, Long> {
}
