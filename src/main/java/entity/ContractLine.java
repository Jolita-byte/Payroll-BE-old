package entity;

import javax.persistence.*;

@Entity
@Table(name = "contract_line")
public class ContractLine {
    public enum AmountType{
        MONTHLY,
        HOURLY,
    }

    @EmbeddedId
    private ContractLineID id;

    @ManyToOne
    @JoinColumn(name="schedule_code_id", nullable=false)
    private ScheduleCode scheduleCode;

    @ManyToOne
    @JoinColumn(name="position_code_id", nullable=false)
    private PositionCode positionCode;

    private Integer staff;
    private ContractLine.AmountType amount_type;
    private Float amount;

    public ContractLine() {
    }

    public ContractLine(ContractLineID id, ScheduleCode scheduleCode, PositionCode positionCode, Integer staff, ContractLine.AmountType amount_type, Float amount) {
        this.id = id;
        this.scheduleCode = scheduleCode;
        this.positionCode = positionCode;
        this.staff = staff;
        this.amount_type = amount_type;
        this.amount = amount;
    }

    public ContractLineID getId() {
        return id;
    }

    public void setId(ContractLineID id) {
        this.id = id;
    }

    public ScheduleCode getScheduleCode() {
        return scheduleCode;
    }

    public void setScheduleCode(ScheduleCode scheduleCode) {
        this.scheduleCode = scheduleCode;
    }

    public PositionCode getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(PositionCode positionCode) {
        this.positionCode = positionCode;
    }

    public Integer getStaff() {
        return staff;
    }

    public void setStaff(Integer staff) {
        this.staff = staff;
    }

    public ContractLine.AmountType getAmount_type() {
        return amount_type;
    }

    public void setAmount_type(ContractLine.AmountType amount_type) {
        this.amount_type = amount_type;
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
                ", scheduleCode=" + scheduleCode +
                ", positionCode=" + positionCode +
                ", staff=" + staff +
                ", amount_type=" + amount_type +
                ", amount=" + amount +
                '}';
    }
}
