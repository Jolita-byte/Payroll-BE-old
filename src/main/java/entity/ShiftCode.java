package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shift_code")
public class ShiftCode {
    @Id
    private String id;
    private String description;

    @OneToMany(mappedBy="shift_code")
    private List<EmployeeScheduleEntry> employeeScheduleEntries;

    @OneToMany(mappedBy="shift_code")
    private List<SchedulePatternLine> schedulePatternLines;

    @OneToMany(mappedBy="shift_code")
    private List<ShiftLine> shiftLines;

    public ShiftCode() {
    }

    public ShiftCode(String id, String description) {
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

    @Override
    public String toString() {
        return "ShiftCode{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
