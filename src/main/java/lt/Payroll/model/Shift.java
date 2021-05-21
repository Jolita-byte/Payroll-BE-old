package lt.Payroll.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
//@Table(name = "shift")
public class Shift {
    @Id
    private String id;
    private String description;

//    @OneToMany(mappedBy="shift_code")
//    private List<EmployeeScheduleEntry> employeeScheduleEntries;
//
//    @OneToMany(mappedBy="shift_code")
//    private List<SchedulePatternLine> schedulePatternLines;

    @OneToMany(mappedBy="shift")
    private List<ShiftLine> shiftLines;
}
