package entity;

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
    private Employee employee;

    @ManyToOne
    @JoinColumn(name="amount_code_id", nullable=false)
    private AmountCode amountCode;*/

    private EmployeeAmount.AmountType amount_type;
    private Float amount;

    public EmployeeAmount(EmployeeAmountID id, AmountType amount_type, Float amount) {
        this.id = id;
        this.amount_type = amount_type;
        this.amount = amount;
    }

    public EmployeeAmountID getId() {
        return id;
    }

    public void setId(EmployeeAmountID id) {
        this.id = id;
    }

    public AmountType getAmount_type() {
        return amount_type;
    }

    public void setAmount_type(AmountType amount_type) {
        this.amount_type = amount_type;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}
