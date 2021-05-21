package lt.Payroll.model;

import javax.persistence.*;

@Entity
@Table(name = "employee_amount")
public class EmployeeAmount {
    private enum AmountType{
        AMOUNT,
        PERCENT,
    }
    @EmbeddedId
    private EmployeeAmountID id;

/*    @ManyToOne
    @JoinColumn(name="employee_id", nullable=false)
    private Employee lt.Payroll.employee;

    @ManyToOne
    @JoinColumn(name="amount_code_id", nullable=false)
    private AmountCode amountCode;*/

    private EmployeeAmount.AmountType amount_type;
    private Float amount;
}
