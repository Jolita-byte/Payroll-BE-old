package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "time_code")
public class TimeCode {
    @Id
    private String id;

    private String description;

    @OneToMany(mappedBy="time_code")
    private List<EmployeeScheduleEntry> employeeScheduleEntries;

    @OneToMany(mappedBy="time_code")
    private List<EmployeeTimesheetEntry> employeeTimeTableEntries;

    @OneToMany(mappedBy="time_code")
    private List<ShiftLine> shiftLines;

    public TimeCode() {
    }

    public TimeCode(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<EmployeeScheduleEntry> getEmployeeScheduleEntries() {
        return employeeScheduleEntries;
    }

    public void setEmployeeScheduleEntries(List<EmployeeScheduleEntry> employeeScheduleEntries) {
        this.employeeScheduleEntries = employeeScheduleEntries;
    }

    public List<EmployeeTimesheetEntry> getEmployeeTimeTableEntries() {
        return employeeTimeTableEntries;
    }

    public void setEmployeeTimeTableEntries(List<EmployeeTimesheetEntry> employeeTimeTableEntries) {
        this.employeeTimeTableEntries = employeeTimeTableEntries;
    }

    @Override
    public String toString() {
        return "TimeCode{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
