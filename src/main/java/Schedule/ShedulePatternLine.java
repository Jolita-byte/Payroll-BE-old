package Schedule;

import java.time.LocalDate;

public class ShedulePatternLine {
    Integer id;
    String scheduleCodeID;
    LocalDate initielaDate;
    String shiftCodeID;

    public ShedulePatternLine(Integer id, String scheduleCodeID, LocalDate initielaDate, String shiftCodeID) {
        this.id = id;
        this.scheduleCodeID = scheduleCodeID;
        this.initielaDate = initielaDate;
        this.shiftCodeID = shiftCodeID;
    }

    public ShedulePatternLine(String scheduleCodeID, LocalDate initielaDate, String shiftCodeID) {
        this.scheduleCodeID = scheduleCodeID;
        this.initielaDate = initielaDate;
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

    public LocalDate getInitielaDate() {
        return initielaDate;
    }

    public void setInitielaDate(LocalDate initielaDate) {
        this.initielaDate = initielaDate;
    }

    public String getShiftCodeID() {
        return shiftCodeID;
    }

    public void setShiftCodeID(String shiftCodeID) {
        this.shiftCodeID = shiftCodeID;
    }
}
