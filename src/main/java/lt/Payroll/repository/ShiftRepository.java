package lt.Payroll.repository;

import lt.Payroll.model.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public interface ShiftRepository extends JpaRepository<Shift, String> {

}
