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

    @Column(name = "amount_type")
    private EmployeeAmount.AmountType amountType;

    private Float amount;
}
