package entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "employee_timesheet_entry")
public class EmployeeTimesheetEntry {

    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name="contract_id", nullable=false)
    private Contract contract;

    @ManyToOne
    @JoinColumn(name="time_code_id", nullable=false)
    private TimeCode timeCode;

    private Float hours;

}
