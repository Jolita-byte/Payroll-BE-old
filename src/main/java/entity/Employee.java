package entity;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    private Integer id;

    private String name;
    private String second_name;
    private String surname;

    @OneToMany(mappedBy="employee")
    private List<Contract> contracts;

    @OneToMany(mappedBy="id.employee")
    private List<EmployeeAmount> employeeAmountS;

    public Employee() {
    }

    public Employee(Integer id, String name, String second_name, String surname, List<Contract> contracts) {
        this.id = id;
        this.name = name;
        this.second_name = second_name;
        this.surname = surname;
        this.contracts = contracts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", second_name='" + second_name + '\'' +
                ", surname='" + surname + '\'' +
                ", contracts=" + contracts +
                '}';
    }
}
