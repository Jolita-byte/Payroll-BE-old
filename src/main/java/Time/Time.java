package Time;

import java.time.LocalDate;

public class Time {
    private LocalDate date;
    private TimeCode timeCode;
    private float duration;

    public Time(LocalDate date, TimeCode timeCode, float duration) {
        this.date = date;
        this.timeCode = timeCode;
        this.duration = duration;
    }

    public LocalDate getDate() {
        return date;
    }

    public TimeCode getTimeCode() {
        return timeCode;
    }

    public float getDuration() {
        return duration;
    }
}
