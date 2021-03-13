package schedule;

import java.time.LocalDate;

public class SchedulePatternLine {
    private Integer id;
    private String scheduleCodeID;
    private LocalDate initialDate;
    private String shiftCodeID;

    public SchedulePatternLine(Integer id, String scheduleCodeID, LocalDate initialDate, String shiftCodeID) {
        this.id = id;
        this.scheduleCodeID = scheduleCodeID;
        this.initialDate = initialDate;
        this.shiftCodeID = shiftCodeID;
    }

    public SchedulePatternLine(String scheduleCodeID, LocalDate initialDate, String shiftCodeID) {
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
}
