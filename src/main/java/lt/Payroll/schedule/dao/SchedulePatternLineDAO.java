package lt.Payroll.schedule.dao;

import lt.Payroll.schedule.entity.SchedulePatternLine;

import java.time.LocalDate;
import java.util.List;

public interface SchedulePatternLineDAO {
    void createSchedulePatternLine(SchedulePatternLine schedulePatternLine);
    SchedulePatternLine readSchedulePatternLine(Integer id);
    void updateSchedulePatternLine(Integer id, SchedulePatternLine schedulePatternLine);
    void deleteSchedulePatternLine(Integer id);
    List<SchedulePatternLine> getAllSchedulePatternLines(String scheduleCodeID);
    List<SchedulePatternLine> getPatternlinesOnDate(LocalDate date, String scheduleCodeID);
    LocalDate getPatternFirstLineDate(String scheduleCodeID);
    Integer getPatternLength(String scheduleCodeID);


}
