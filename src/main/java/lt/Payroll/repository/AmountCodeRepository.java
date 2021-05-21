package lt.Payroll.repository;

import lt.Payroll.model.AmountCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public interface AmountCodeRepository extends JpaRepository<AmountCode, String> {

}
