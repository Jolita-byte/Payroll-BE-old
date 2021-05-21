package lt.Payroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import lt.Payroll.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
