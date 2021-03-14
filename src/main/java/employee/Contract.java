package employee;

import java.time.LocalDate;

public class Contract {
    private Integer id;
    private Integer employeeID;
    private LocalDate EmploymentDate;
    private LocalDate ContractSignDate;
    private LocalDate TerminationDate;

    public Contract(Integer employeeID, LocalDate employmentDate, LocalDate contractSignDate, LocalDate terminationDate) {
        this.employeeID = employeeID;
        EmploymentDate = employmentDate;
        ContractSignDate = contractSignDate;
        TerminationDate = terminationDate;
    }

    public Contract(Integer id, Integer employeeID, LocalDate employmentDate, LocalDate contractSignDate, LocalDate terminationDate) {
        this.id = id;
        this.employeeID = employeeID;
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
                ", employeeID=" + employeeID +
                ", EmploymentDate=" + EmploymentDate +
                ", ContractSignDate=" + ContractSignDate +
                ", TerminationDate=" + TerminationDate +
                '}';
    }
}
