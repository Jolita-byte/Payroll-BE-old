package Employee;

import General.Code;

import java.time.LocalDate;

public interface ContractDAO {
    void createContract(ContractLine contractLine);
    void updateSchedule(Code schedule);
    void updatePosition(Code position);
    void updateStaff(Code staff);
    void updateAmount(float amount, ContractLine.AmountType amountType);
    void terminateContract(LocalDate terminationDate);
}
