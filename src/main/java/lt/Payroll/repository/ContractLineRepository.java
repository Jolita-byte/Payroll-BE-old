package lt.Payroll.repository;

import lt.Payroll.model.ContractLine;
import lt.Payroll.model.ContractLineID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ContractLineRepository extends JpaRepository<ContractLine, ContractLineID> {

    @Query(value = "SELECT cl from ContractLine as cl WHERE cl.id.contract.id = :contract_id")
    List<ContractLine> findAllByContractId(Long contract_id);

    @Query(nativeQuery = true, value = "SELECT * FROM contract_line as cl WHERE cl.contract_id = :contract_id AND cl.start_date <= :date ORDER BY cl.start_date desc limit 1")
    ContractLine findValidOnDate(Long contract_id, LocalDate date);

/*    public ContractLineRepository(EntityManager entityManager) {
        super(entityManager, ContractLine.class);
    }*/

/*    public List<ContractLine> findValidOnDate(Integer contract_id, LocalDate date) {
//        String sql = "FROM contract_line " +
//                "WHERE contract_id = 1 AND start_date <= 2021-01-01 " +
//                "ORDER BY start_date desc";
        String sql = "FROM ContractLine";
        return entityManager
                .createQuery(sql, ContractLine.class)
                //.setParameter("C", contract_id)
                //.setParameter("D", date)
        .getResultList();
                //.getSingleResult();
    }*/
}
