package lt.Payroll.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String second_name;
    private String surname;

    @OneToMany(mappedBy="employee")
    private List<Contract> contracts;

    //@OneToMany(mappedBy="id.lt.Payroll.employee") //likinai
    //private List<EmployeeAmount> employeeAmounts; //laikiai
}
