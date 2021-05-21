package lt.Payroll.repository;

import lt.Payroll.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {

}
