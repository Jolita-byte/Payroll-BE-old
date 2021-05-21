package lt.Payroll.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "employee_schedule_entry")
public class EmployeeScheduleEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="contract_id", nullable=false)
    private Contract contract;

    @ManyToOne
    @JoinColumn(name="shift_id", nullable=false)
    //@Column(name = "shift_code")
    private Shift shift;

    @ManyToOne
    @JoinColumn(name="activity_code_id", nullable=false)
    //@Column (name = "activity_code")
    private ActivityCode activityCode;

    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
}
