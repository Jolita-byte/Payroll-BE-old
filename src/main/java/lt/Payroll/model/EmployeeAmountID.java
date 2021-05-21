package lt.Payroll.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class EmployeeAmountID implements Serializable {
    @ManyToOne
    @JoinColumn(name="employee_id", nullable=false)
    private Employee employee;

    private LocalDate start_date;

    @ManyToOne
    @JoinColumn(name="amount_code_id", nullable=false)
    private AmountCode amountCode;
}
