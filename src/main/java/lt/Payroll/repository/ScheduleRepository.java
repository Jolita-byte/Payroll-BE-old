package lt.Payroll.repository;

import lt.Payroll.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, String> {

}
