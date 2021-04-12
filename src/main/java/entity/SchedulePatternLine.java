package entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "schedule_pattern_line")
public class SchedulePatternLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String schedule_code_id;
    private LocalDate initial_date;
    private String shift_code_id;

    public SchedulePatternLine() {
    }

    public SchedulePatternLine(String schedule_code_id, LocalDate initial_date, String shift_code_id) {
        this.schedule_code_id = schedule_code_id;
        this.initial_date = initial_date;
        this.shift_code_id = shift_code_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSchedule_code_id() {
        return schedule_code_id;
    }

    public void setSchedule_code_id(String schedule_code_id) {
        this.schedule_code_id = schedule_code_id;
    }

    public LocalDate getInitial_date() {
        return initial_date;
    }

    public void setInitial_date(LocalDate initial_date) {
        this.initial_date = initial_date;
    }

    public String getShift_code_id() {
        return shift_code_id;
    }

    public void setShift_code_id(String shift_code_id) {
        this.shift_code_id = shift_code_id;
    }

    @Override
    public String toString() {
        return "SchedulePatternLine{" +
                "id=" + id +
                ", schedule_code_id='" + schedule_code_id + '\'' +
                ", initial_date=" + initial_date +
                ", shift_code_id='" + shift_code_id + '\'' +
                '}';
    }
}
