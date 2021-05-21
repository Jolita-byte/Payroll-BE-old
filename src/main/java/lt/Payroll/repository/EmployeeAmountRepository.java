package lt.Payroll.repository;

import lt.Payroll.model.EmployeeAmount;
import lt.Payroll.model.EmployeeAmountID;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public interface EmployeeAmountRepository extends JpaRepository<EmployeeAmount, EmployeeAmountID> {
}
