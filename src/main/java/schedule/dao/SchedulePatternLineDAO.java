package schedule.dao;

import schedule.entity.SchedulePatternLine;

import java.util.Optional;

public interface SchedulePatternLineDAO {
    void createSchedulePatternLine(SchedulePatternLine schedulePatternLine);
    Optional<SchedulePatternLine> readSchedulePatternLine(Integer id);
    void updateSchedulePatternLine(Integer id, SchedulePatternLine schedulePatternLine);
    void deleteSchedulePatternLine(Integer id);
    //List<SchedulePatternLine> findAllP(Integer id);
}
