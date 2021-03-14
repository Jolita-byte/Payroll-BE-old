package schedule;

import employee.Employee;
import general.Code;
import general.CodeDAO;
import schedule.dao.EmployeeScheduleLineDAO;
import schedule.dao.ShiftLineDAO;
import schedule.entity.EmployeeScheduleLine;
import schedule.entity.SchedulePatternLine;
import schedule.entity.ShiftLine;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;


public class ScheduleService {
    private final Employee employee;
    private final CodeDAO codeDAO;
    private final EmployeeScheduleLineDAO employeeScheduleLineDAO;
    //private final ShiftLineDAO shiftLineDAO;


    public ScheduleService(Employee employee, CodeDAO codeDAO, EmployeeScheduleLineDAO employeeScheduleLineDAO) {
        this.employee = employee;
        this.codeDAO = codeDAO;
        this.employeeScheduleLineDAO = employeeScheduleLineDAO;
    }

    public List<EmployeeScheduleLine> fillEmployeeSchedule(Integer employeeID, LocalDate begin, LocalDate end){
        //ContractDAO contractDAO = new ContractDAOImpl();
        List<EmployeeScheduleLine> employeeScheduleLines = null;
        for (LocalDate i = begin; i.isBefore(end)||i.isEqual(end); i.plusDays(1)) {
            //fillEmployeeScheduleLines()


        }


        return null;
    }

    //public List<EmployeeScheduleLine> get(LocalDate date, Code schedule){

    //}

    public List<SchedulePatternLine> getPatternline (LocalDate date, List<SchedulePatternLine> schedulePatternLines){
        LocalDate patternFirstDate = getPatternFirstDate(schedulePatternLines);
        Long diff = Math.abs(DAYS.between(date, patternFirstDate));
        Long patternLineNo = diff % getPatternDuration(schedulePatternLines);
        LocalDate patternLineDate = DAYS.addTo(patternFirstDate, patternLineNo);
        return schedulePatternLines
                .stream()
                .filter(x -> x.getInitialDate().isEqual(patternLineDate))
                .collect(Collectors.toList());
    }

    public LocalDate getPatternFirstDate(List<SchedulePatternLine> schedulePatternLines){
        return schedulePatternLines
                .stream()
                .min(Comparator.comparing(SchedulePatternLine::getInitialDate))
                .get().getInitialDate();
    }

    private int getPatternDuration (List<SchedulePatternLine> schedulePatternLines){
        return (int) schedulePatternLines
                .stream()
                .map(x -> x.getInitialDate())
                .distinct().count();
    }

    public List<EmployeeScheduleLine> fillEmployeeScheduleLines(LocalDate date, Code shift){
        return codeDAO
                .findShiftLines(shift)
                .stream()
                .map(x -> fillEmployeeScheduleLine(date, x))
                .collect(Collectors.toList());
    }

    private EmployeeScheduleLine fillEmployeeScheduleLine(LocalDate date, ShiftLine shiftLine){
        LocalDateTime startDateTime = LocalDateTime.of(date, shiftLine.getBegin());
        LocalDateTime endDateTime;
        if (shiftLine.getBegin().isBefore(shiftLine.getEnd())){
            endDateTime = LocalDateTime.of(date, shiftLine.getEnd());
        } else endDateTime = LocalDateTime.of(date.plusDays(1), shiftLine.getEnd());

        return new EmployeeScheduleLine(
                employee.getId(),
                shiftLine.getShiftCodeID(),
                shiftLine.getTimeCodeID(),
                startDateTime,
                endDateTime);
    }

    /**
     * function fills time schedule for specified employee for specipied period of time
     * - loop trough each day in the period
     * - find Employee contracts in each day
     * - loop trough contracts to fill schedule for each cotract
     * - find time schedule for specified contract and day
     * - find pattern lines for specified day and schedule
     * - find shift lines for specified shift
     * - create Employee Schedule lines for each shift line
     */

    /*



   * search for employee

   */
}
