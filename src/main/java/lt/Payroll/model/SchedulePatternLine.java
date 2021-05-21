package lt.Payroll.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
//@Table(name = "schedule_pattern_line")
public class SchedulePatternLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="schedule_id", nullable=false)
    private Schedule schedule;

    @Column(name = "initial_date")
    private LocalDate initialDate;

    @ManyToOne
    @JoinColumn(name="shift_id", nullable=false)
    private Shift shift;

}
