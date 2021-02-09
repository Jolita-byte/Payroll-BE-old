package Employee;

import General.Code;

import java.time.LocalDate;

public class ContractLine {

    public enum AmountType{
        MONTHLY,
        HOURLY,
    }

    private Integer id;
    private Contract contract;
    private LocalDate startDate;
    private LocalDate endDate;
    private Code schedule;
    private Code position;
    private int staff;
    private AmountType amountType;
    private float amount;

    public ContractLine(Contract contract, LocalDate startDate, LocalDate endDate, Code schedule, Code position, int staff, AmountType amountType, float amount) {
        this.contract = contract;
        this.startDate = startDate;
        this.endDate = endDate;
        this.schedule = schedule;
        this.position = position;
        this.staff = staff;
        this.amountType = amountType;
        this.amount = amount;
    }

    public ContractLine(Integer id, Contract contract, LocalDate startDate, LocalDate endDate, Code schedule, Code position, int staff, AmountType amountType, float amount) {
        this.id = id;
        this.contract = contract;
        this.startDate = startDate;
        this.endDate = endDate;
        this.schedule = schedule;
        this.position = position;
        this.staff = staff;
        this.amountType = amountType;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Code getSchedule() {
        return schedule;
    }

    public void setSchedule(Code schedule) {
        this.schedule = schedule;
    }

    public Code getPosition() {
        return position;
    }

    public void setPosition(Code position) {
        this.position = position;
    }

    public int getStaff() {
        return staff;
    }

    public void setStaff(int staff) {
        this.staff = staff;
    }

    public AmountType getAmountType() {
        return amountType;
    }

    public void setAmountType(AmountType amountType) {
        this.amountType = amountType;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
