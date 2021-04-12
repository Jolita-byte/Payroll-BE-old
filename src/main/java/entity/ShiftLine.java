package entity;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "shift_line")
public class ShiftLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String shift_code_id;
    private String time_code_id;
    private LocalTime begin;
    private LocalTime end;

    public ShiftLine() {
    }

    public ShiftLine(String shift_code_id, String time_code_id, LocalTime begin, LocalTime end) {
        this.shift_code_id = shift_code_id;
        this.time_code_id = time_code_id;
        this.begin = begin;
        this.end = end;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShift_code_id() {
        return shift_code_id;
    }

    public void setShift_code_id(String shift_code_id) {
        this.shift_code_id = shift_code_id;
    }

    public String getTime_code_id() {
        return time_code_id;
    }

    public void setTime_code_id(String time_code_id) {
        this.time_code_id = time_code_id;
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
}

