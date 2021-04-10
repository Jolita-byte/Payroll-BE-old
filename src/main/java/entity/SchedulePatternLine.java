package entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "schedule_pattern_line")
public class SchedulePatternLine {

    @Id
    private Integer id;
    private String scheduleCodeID;
    private LocalDate initialDate;
    private String shiftCodeID;

    public SchedulePatternLine() {
    }

    public SchedulePatternLine(Integer id, String scheduleCodeID, LocalDate initialDate, String shiftCodeID) {
        this.id = id;
        this.scheduleCodeID = scheduleCodeID;
        this.initialDate = initialDate;
        this.shiftCodeID = shiftCodeID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getScheduleCodeID() {
        return scheduleCodeID;
    }

    public void setScheduleCodeID(String scheduleCodeID) {
        this.scheduleCodeID = scheduleCodeID;
    }

    public LocalDate getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(LocalDate initialDate) {
        this.initialDate = initialDate;
    }

    public String getShiftCodeID() {
        return shiftCodeID;
    }

    public void setShiftCodeID(String shiftCodeID) {
        this.shiftCodeID = shiftCodeID;
    }

    @Override
    public String toString() {
        return "SchedulePatternLine{" +
                "id=" + id +
                ", scheduleCodeID='" + scheduleCodeID + '\'' +
                ", initialDate=" + initialDate +
                ", shiftCodeID='" + shiftCodeID + '\'' +
                '}';
    }
}
