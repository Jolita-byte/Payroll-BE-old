package employee;

import java.time.LocalDate;

public class ContractLine {

    public enum AmountType{
        MONTHLY,
        HOURLY,
    }

    private Integer contractID;
    private LocalDate startDate;
    private String scheduleID;
    private String positionID;
    private Integer staff;
    private AmountType amountType;
    private Float amount;

    public ContractLine(Integer contractID, LocalDate startDate, String scheduleID, String positionID, Integer staff, AmountType amountType, Float amount) {
        this.contractID = contractID;
        this.startDate = startDate;
        this.scheduleID = scheduleID;
        this.positionID = positionID;
        this.staff = staff;
        this.amountType = amountType;
        this.amount = amount;
    }

    public ContractLine(LocalDate startDate, String scheduleID, String positionID, Integer staff, AmountType amountType, Float amount) {
        this.startDate = startDate;
        this.scheduleID = scheduleID;
        this.positionID = positionID;
        this.staff = staff;
        this.amountType = amountType;
        this.amount = amount;
    }

    public ContractLine(String scheduleID, String positionID, Integer staff, AmountType amountType, Float amount) {
        this.scheduleID = scheduleID;
        this.positionID = positionID;
        this.staff = staff;
        this.amountType = amountType;
        this.amount = amount;
    }

    public Integer getContractID() {
        return contractID;
    }

    public void setContractID(Integer contractID) {
        this.contractID = contractID;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
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

    public AmountType getAmountType() {
        return amountType;
    }

    public void setAmountType(AmountType amountType) {
        this.amountType = amountType;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
