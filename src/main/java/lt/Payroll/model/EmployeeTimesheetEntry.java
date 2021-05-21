package lt.Payroll.model;

import javax.persistence.*;

@Entity
@Table(name = "employee_timesheet_entry")
public class EmployeeTimesheetEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="contract_id", nullable=false)
    private Contract contract;

    @ManyToOne
    @JoinColumn(name="time_code_id", nullable=false)
    private ActivityCode time_code;

    private Float hours;

}
