package lt.Payroll.repository;

import lt.Payroll.model.ActivityCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityCodeRepository extends JpaRepository<ActivityCode, String> {
}
