package Employee;

import java.sql.Date;
import java.time.LocalDate;

public class Contract {
    private Integer id;
    private Employee employee;
    private LocalDate EmploymentDate;
    private LocalDate ContractSignDate;
    private LocalDate TerminaitionDate;

    public Contract(Employee employee, LocalDate employmentDate, LocalDate contractSignDate, LocalDate terminaitionDate) {
        this.employee = employee;
        EmploymentDate = employmentDate;
        ContractSignDate = contractSignDate;
        TerminaitionDate = terminaitionDate;
    }

    public Contract(Integer id, Employee employee, LocalDate employmentDate, LocalDate contractSignDate, LocalDate terminaitionDate) {
        this.id = id;
        this.employee = employee;
        EmploymentDate = employmentDate;
        ContractSignDate = contractSignDate;
        TerminaitionDate = terminaitionDate;
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

    public LocalDate getTerminaitionDate() {
        return TerminaitionDate;
    }

    public void setTerminaitionDate(LocalDate terminaitionDate) {
        TerminaitionDate = terminaitionDate;
    }
}
