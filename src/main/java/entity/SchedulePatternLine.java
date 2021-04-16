package entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "schedule_pattern_line")
public class SchedulePatternLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="schedule_code_id", nullable=false)
    private ScheduleCode schedule_code;

    private LocalDate initial_date;

    @ManyToOne
    @JoinColumn(name="shift_code_id", nullable=false)
    private ShiftCode shift_code;

    public SchedulePatternLine() {
    }

    public SchedulePatternLine(ScheduleCode schedule_code, LocalDate initial_date, ShiftCode shift_code) {
        this.schedule_code = schedule_code;
        this.initial_date = initial_date;
        this.shift_code = shift_code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ScheduleCode getSchedule_code() {
        return schedule_code;
    }

    public void setSchedule_code(ScheduleCode schedule_code) {
        this.schedule_code = schedule_code;
    }

    public LocalDate getInitial_date() {
        return initial_date;
    }

    public void setInitial_date(LocalDate initial_date) {
        this.initial_date = initial_date;
    }

    public ShiftCode getShift_code() {
        return shift_code;
    }

    public void setShift_code(ShiftCode shift_code) {
        this.shift_code = shift_code;
    }

    @Override
    public String toString() {
        return "SchedulePatternLine{" +
                "id=" + id +
                ", schedule_code=" + schedule_code +
                ", initial_date=" + initial_date +
                ", shift_code=" + shift_code +
                '}';
    }
}
