package lt.Payroll.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Data
//@Table(name = "shift_line")
public class ShiftLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="shift_id", nullable=false)
    private Shift shift;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="activity_code_id", nullable=false)
    private ActivityCode activityCode;

    private LocalTime start;
    private LocalTime end;
}

