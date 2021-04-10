package entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "employee_time_table_entry")
public class EmployeeTimeTableEntry {

    @Id
    private Integer id;
    private Integer employeeID;
    private Integer contractID;
    private String timeCodeID;
    private Float hours;

}
