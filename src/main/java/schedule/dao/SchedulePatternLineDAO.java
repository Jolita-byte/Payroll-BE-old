package schedule.dao;

import schedule.entity.SchedulePatternLine;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
