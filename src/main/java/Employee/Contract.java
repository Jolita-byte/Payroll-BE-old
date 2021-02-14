package Employee;

import java.time.LocalDate;

public class Contract {
    private Integer id;
    private Integer employeeID;
    private LocalDate EmploymentDate;
    private LocalDate ContractSignDate;
    private LocalDate TerminaitionDate;

    public Contract(Integer employeeID, LocalDate employmentDate, LocalDate contractSignDate, LocalDate terminaitionDate) {
        this.employeeID = employeeID;
        EmploymentDate = employmentDate;
        ContractSignDate = contractSignDate;
        TerminaitionDate = terminaitionDate;
    }

    public Contract(Integer id, Integer employeeID, LocalDate employmentDate, LocalDate contractSignDate, LocalDate terminaitionDate) {
        this.id = id;
        this.employeeID = employeeID;
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

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployee(Integer employeeId) {
        this.employeeID = employeeId;
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
