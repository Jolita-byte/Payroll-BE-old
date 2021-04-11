package entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "contract")
public class Contract {

    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name="employee_id", nullable=false)
    private Employee employee;

    private LocalDate employment_date;
    private LocalDate contract_sign_date;
    private LocalDate termination_date;

    @OneToMany(mappedBy="contract")
    private List<EmployeeTimesheetEntry> employeeTimesheetEntries;

    public Contract() {
    }


}
