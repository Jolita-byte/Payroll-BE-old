package entity;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "shift_line")
public class ShiftLine {

    @Id
    private Integer id;
    private String shiftCodeID;
    private String timeCodeID;
    private LocalTime begin;
    private LocalTime end;

    public ShiftLine() {
    }

    public ShiftLine(Integer id, String shiftCodeID, String timeCodeID, LocalTime begin, LocalTime end) {
        this.id = id;
        this.shiftCodeID = shiftCodeID;
        this.timeCodeID = timeCodeID;
        this.begin = begin;
        this.end = end;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShiftCodeID() {
        return shiftCodeID;
    }

    public void setShiftCodeID(String shiftCodeID) {
        this.shiftCodeID = shiftCodeID;
    }

    public String getTimeCodeID() {
        return timeCodeID;
    }

    public void setTimeCodeID(String timeCodeID) {
        this.timeCodeID = timeCodeID;
    }

    public LocalTime getBegin() {
        return begin;
    }

    public void setBegin(LocalTime begin) {
        this.begin = begin;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "ShiftLine{" +
                "id=" + id +
                ", shiftCodeID='" + shiftCodeID + '\'' +
                ", timeCodeID='" + timeCodeID + '\'' +
                ", begin=" + begin +
                ", end=" + end +
                '}';
    }
}

