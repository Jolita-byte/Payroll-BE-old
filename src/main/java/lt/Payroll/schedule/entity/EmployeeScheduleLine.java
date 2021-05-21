package lt.Payroll.schedule.entity;

import java.time.LocalDateTime;

public class EmployeeScheduleLine {
    private Integer id;
    private Integer employeeID;
    private Integer contractID;
    private String shiftCodeID;
    private String timeCodeID;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    public EmployeeScheduleLine(Integer id, Integer employeeID, Integer contractID, String shiftCodeID, String timeCodeID, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this.id = id;
        this.employeeID = employeeID;
        this.contractID = contractID;
        this.shiftCodeID = shiftCodeID;
        this.timeCodeID = timeCodeID;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    public EmployeeScheduleLine(Integer employeeID, Integer contractID, String shiftCodeID, String timeCodeID, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this.employeeID = employeeID;
        this.contractID = contractID;
        this.shiftCodeID = shiftCodeID;
        this.timeCodeID = timeCodeID;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public Integer getContractID() {
        return contractID;
    }

    public void setContractID(Integer contractID) {
        this.contractID = contractID;
    }

    public String getShiftCodeID() {
        return shiftCodeID;
    }

    public void setShiftCodeID(String shiftCodeID) {
        this.shiftCodeID = shiftCodeID;
    }

    public String getTimeCodeID() {
        return timeCodeID;
    }

    public void setTimeCodeID(String timeCodeID) {
        this.timeCodeID = timeCodeID;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    @Override
    public String toString() {
        return "\n EmployeeScheduleLine{" +
                "id=" + id +
                ", employeeID=" + employeeID +
                ", contractID=" + contractID +
                ", shiftCodeID='" + shiftCodeID + '\'' +
                ", timeCodeID='" + timeCodeID + '\'' +
                ", startDateTime=" + startDateTime +
                ", endDateTime=" + endDateTime +
                '}';
    }
}
