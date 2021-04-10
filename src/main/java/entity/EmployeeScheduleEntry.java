package entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "employee_schedule_entry")
public class EmployeeScheduleEntry {

    @Id
    private Integer id;
    private Integer employeeID;
    private Integer contractID;
    private String shiftCodeID;
    private String timeCodeID;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

}
