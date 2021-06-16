package lt.Payroll.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class EmployeeAmountID implements Serializable {

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="contract_id", nullable=false)
    private Contract contract;

    private LocalDate start_date;

    @ManyToOne
    @JoinColumn(name="amount_code_id", nullable=false)
    private AmountCode amountCode;
}
