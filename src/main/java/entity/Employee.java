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
    private String secondName;
    private String surname;

    @OneToMany(mappedBy="employee")
    private List<Contract> contracts;

    public Employee() {
    }

    public Employee(Integer id, String name, String secondName, String surname, List<Contract> contracts) {
        this.id = id;
        this.name = name;
        this.secondName = secondName;
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

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
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
                ", secondName='" + secondName + '\'' +
                ", surname='" + surname + '\'' +
                ", contracts=" + contracts.stream().map(Contract::toString).collect(Collectors.toList()) +
                '}';
    }
}
