package entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "contract_line")
public class ContractLine {
    public enum AmountType{
        MONTHLY,
        HOURLY,
    }

    //private Integer contractID;
    //private LocalDate startDate;
    @EmbeddedId
    private ContractLineID id;

    private String scheduleID;
    private String positionID;
    private Integer staff;
    private employee.ContractLine.AmountType amountType;
    private Float amount;

    public ContractLine() {
    }

    public ContractLineID getId() {
        return id;
    }

    public void setId(ContractLineID id) {
        this.id = id;
    }

    public String getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(String scheduleID) {
        this.scheduleID = scheduleID;
    }

    public String getPositionID() {
        return positionID;
    }

    public void setPositionID(String positionID) {
        this.positionID = positionID;
    }

    public Integer getStaff() {
        return staff;
    }

    public void setStaff(Integer staff) {
        this.staff = staff;
    }

    public employee.ContractLine.AmountType getAmountType() {
        return amountType;
    }

    public void setAmountType(employee.ContractLine.AmountType amountType) {
        this.amountType = amountType;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ContractLine{" +
                "id=" + id +
                ", scheduleID='" + scheduleID + '\'' +
                ", positionID='" + positionID + '\'' +
                ", staff=" + staff +
                ", amountType=" + amountType +
                ", amount=" + amount +
                '}';
    }
}
