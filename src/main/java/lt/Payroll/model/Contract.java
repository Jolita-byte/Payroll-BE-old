package lt.Payroll.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
//@Table(name = "contract")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="employee_id", nullable=false)
    private Employee employee;

    private LocalDate employment_date;
    private LocalDate contract_sign_date;
    private LocalDate termination_date;

    @OneToMany(mappedBy = "id.contract")
    private List<ContractLine> contractLines;

    @OneToMany(mappedBy = "id.contract")
    private List<EmployeeAmount> employeeAmounts;


    /*@OneToMany(mappedBy="contract")
    private List<EmployeeScheduleEntry> employeeScheduleEntries;

    @OneToMany(mappedBy="contract")
    private List<EmployeeTimesheetEntry> employeeTimesheetEntries;*/
}
