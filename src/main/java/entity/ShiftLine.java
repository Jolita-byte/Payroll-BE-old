package entity;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "shift_line")
public class ShiftLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="shift_code_id", nullable=false)
    private ShiftCode shift_code;

    @ManyToOne
    @JoinColumn(name="time_code_id", nullable=false)
    private TimeCode time_code;

    private LocalTime begin;
    private LocalTime end;

    public ShiftLine() {
    }

    public ShiftLine(ShiftCode shift_code, TimeCode time_code, LocalTime begin, LocalTime end) {
        this.shift_code = shift_code;
        this.time_code = time_code;
        this.begin = begin;
        this.end = end;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ShiftCode getShift_code() {
        return shift_code;
    }

    public void setShift_code(ShiftCode shift_code) {
        this.shift_code = shift_code;
    }

    public TimeCode getTime_code() {
        return time_code;
    }

    public void setTime_code(TimeCode time_code) {
        this.time_code = time_code;
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
                ", shift_code=" + shift_code +
                ", time_code=" + time_code +
                ", begin=" + begin +
                ", end=" + end +
                '}';
    }
}

