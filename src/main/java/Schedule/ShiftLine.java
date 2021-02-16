package Schedule;

import java.time.LocalTime;

public class ShiftLine {
    Integer id;
    String shiftCodeID;
    String timeCodeID;
    LocalTime begin;
    LocalTime end;

    public ShiftLine(Integer id, String shiftCodeID, String timeCodeID, LocalTime begin, LocalTime end) {
        this.id = id;
        this.shiftCodeID = shiftCodeID;
        this.timeCodeID = timeCodeID;
        this.begin = begin;
        this.end = end;
    }

    public ShiftLine(String shiftCodeID, String timeCodeID, LocalTime begin, LocalTime end) {
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
}
