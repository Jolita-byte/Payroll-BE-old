package lt.Payroll.model;



import javax.persistence.*;
import lombok.Data;
import java.util.List;


@Entity
@Data
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String second_name;
    private String surname;

    @OneToMany(mappedBy="employee")
    private List<Contract> contracts;
}
