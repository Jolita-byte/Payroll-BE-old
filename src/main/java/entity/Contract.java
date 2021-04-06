package entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "contract")
public class Contract {

    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name="employee_id", nullable=false)
    private Employee employee;
    private LocalDate EmploymentDate;
    private LocalDate ContractSignDate;
    private LocalDate TerminationDate;

    public Contract() {
    }

    public Contract(Integer id, Employee employee, LocalDate employmentDate, LocalDate contractSignDate, LocalDate terminationDate) {
        this.id = id;
        this.employee = employee;
        EmploymentDate = employmentDate;
        ContractSignDate = contractSignDate;
        TerminationDate = terminationDate;
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

    public LocalDate getEmploymentDate() {
        return EmploymentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        EmploymentDate = employmentDate;
    }

    public LocalDate getContractSignDate() {
        return ContractSignDate;
    }

    public void setContractSignDate(LocalDate contractSignDate) {
        ContractSignDate = contractSignDate;
    }

    public LocalDate getTerminationDate() {
        return TerminationDate;
    }

    public void setTerminationDate(LocalDate terminationDate) {
        TerminationDate = terminationDate;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                //", employee=" + employee +
                ", EmploymentDate=" + EmploymentDate +
                ", ContractSignDate=" + ContractSignDate +
                ", TerminationDate=" + TerminationDate +
                '}';
    }
}
