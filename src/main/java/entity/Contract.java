package entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "contract")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Contract(Employee employee, LocalDate employment_date, LocalDate contract_sign_date, LocalDate termination_date) {
        this.employee = employee;
        this.employment_date = employment_date;
        this.contract_sign_date = contract_sign_date;
        this.termination_date = termination_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDate getEmployment_date() {
        return employment_date;
    }

    public void setEmployment_date(LocalDate employment_date) {
        this.employment_date = employment_date;
    }

    public LocalDate getContract_sign_date() {
        return contract_sign_date;
    }

    public void setContract_sign_date(LocalDate contract_sign_date) {
        this.contract_sign_date = contract_sign_date;
    }

    public LocalDate getTermination_date() {
        return termination_date;
    }

    public void setTermination_date(LocalDate termination_date) {
        this.termination_date = termination_date;
    }

    public List<EmployeeTimesheetEntry> getEmployeeTimesheetEntries() {
        return employeeTimesheetEntries;
    }

    public void setEmployeeTimesheetEntries(List<EmployeeTimesheetEntry> employeeTimesheetEntries) {
        this.employeeTimesheetEntries = employeeTimesheetEntries;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", employee=" + employee +
                ", employment_date=" + employment_date +
                ", contract_sign_date=" + contract_sign_date +
                ", termination_date=" + termination_date +
                ", employeeTimesheetEntries=" + employeeTimesheetEntries +
                '}';
    }
}
