package lt.Payroll.model.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ContractDTO {
    private Long employee_id;
    private LocalDate employment_date;
    private LocalDate contract_sign_date;
    private LocalDate termination_date;
}
