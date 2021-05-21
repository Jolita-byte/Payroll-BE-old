package lt.Payroll.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "activity_code")
public class ActivityCode {
    @Id
    private String id;

    private String description;

//    @OneToMany(mappedBy="time_code")
//    private List<EmployeeScheduleEntry> employeeScheduleEntries;
//
//    @OneToMany(mappedBy="time_code")
//    private List<EmployeeTimesheetEntry> employeeTimeTableEntries;

    @OneToMany(mappedBy="activityCode")
    private List<ShiftLine> shiftLines;


}
