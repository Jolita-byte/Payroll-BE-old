package entity;

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

    public EmployeeAmountID(Employee employee, LocalDate start_date, AmountCode amountCode) {
        this.employee = employee;
        this.start_date = start_date;
        this.amountCode = amountCode;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public AmountCode getAmountCode() {
        return amountCode;
    }

    public void setAmountCode(AmountCode amountCode) {
        this.amountCode = amountCode;
    }

    @Override
    public String toString() {
        return "EmployeeAmountID{" +
                "employee=" + employee +
                ", start_date=" + start_date +
                ", amountCode=" + amountCode +
                '}';
    }
}
