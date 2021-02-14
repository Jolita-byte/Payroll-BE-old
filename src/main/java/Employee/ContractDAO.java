package Employee;

import General.Code;

import java.time.LocalDate;
import java.util.Optional;

public interface ContractDAO {
    void createContract(Contract contract, ContractLine contractLine);
    void updateContract(int id, LocalDate newDate, ContractLine contractUpdates);
    void createContractLine(int contractID, LocalDate startDate, ContractLine contractLine);
    void updateContractLine(int contractID, LocalDate startDate, ContractLine contractLine);
    void terminateContract(LocalDate terminationDate);
    Optional<ContractLine> findContractLineByPK(int contractID, LocalDate startDate);
}
