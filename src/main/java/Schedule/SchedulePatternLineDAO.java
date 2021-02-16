package Schedule;

import java.util.Optional;

public interface SchedulePatternLineDAO {
    void createSchedulePatternLine(SchedulePatternLine schedulePatternLine);
    Optional<SchedulePatternLine> readSchedulePatternLine(Integer id);
    void updateSchedulePatternLine(Integer id, SchedulePatternLine schedulePatternLine);
    void deleteSchedulePatternLine(Integer id);
}
