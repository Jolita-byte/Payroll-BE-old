package time;

import general.Code;
import java.time.LocalDate;


public class Time {
    private LocalDate date;
    private Code timeCode;
    private float duration;

    public Time(LocalDate date, Code timeCode, float duration) {
        this.date = date;
        this.timeCode = timeCode;
        this.duration = duration;
    }

    public LocalDate getDate() {
        return date;
    }

    public Code getTimeCode() {
        return timeCode;
    }

    public float getDuration() {
        return duration;
    }
}
