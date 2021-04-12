package schedule;

import entity.*;

import employee.ContractContractLine;
import employee.ContractDAO;
import employee.Employee;
import general.Code;
import general.CodeDAO;
import schedule.dao.EmployeeScheduleLineDAO;
import schedule.dao.SchedulePatternLineDAO;
import schedule.dao.ShiftLineDAO;
import schedule.entity.EmployeeScheduleLine;
import schedule.entity.SchedulePatternLine;
import schedule.entity.ShiftLine;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;


public class ScheduleService {
    private final Employee employee;
    private List<EmployeeScheduleLine> employeeScheduleLines;
    private final ContractDAO contractDAO;
    private final CodeDAO codeDAO;
    private final SchedulePatternLineDAO schedulePatternLineDAO;
    private final EmployeeScheduleLineDAO employeeScheduleLineDAO;
    //private final ShiftLineDAO shiftLineDAO;


    public ScheduleService(Employee employee, ContractDAO contractDAO, CodeDAO codeDAO, SchedulePatternLineDAO schedulePatternLineDAO, EmployeeScheduleLineDAO employeeScheduleLineDAO) {
        this.employee = employee;
        this.contractDAO = contractDAO;
        this.codeDAO = codeDAO;
        this.schedulePatternLineDAO = schedulePatternLineDAO;
        this.employeeScheduleLineDAO = employeeScheduleLineDAO;
        this.employeeScheduleLines = new ArrayList<>();
    }

    public void fillEmployeeSchedule(Integer employeeID, LocalDate begin, LocalDate end) {
        for (LocalDate i = begin; (i.isBefore(end) || i.isEqual(end)); i = i.plusDays(1)) {
            LocalDate finalI = i;
            contractDAO
                    .findEmployeeContractContractLinesByDate(employeeID, i)
                    .stream()
                    .forEach(x -> fillContractSchedule(finalI,x));
        }
    }

    public void fillContractSchedule(LocalDate date, ContractContractLine contractContractLine) {
        schedulePatternLineDAO
                .getPatternlinesOnDate(date, contractContractLine.getContractLine().getScheduleID())
                .stream()
                .forEach(x -> fillEmployeeScheduleLines(contractContractLine.getContract().getId(), date, x.getShiftCodeID()));
                //.forEach(x -> fillSchedulePatternLine(contractContractLine.getContract().getId(), date, x));


        /*List<SchedulePatternLine> schedulePatternLines = schedulePatternLineDAO.getAllSchedulePatternLines(contractContractLine.getContractLine().getScheduleID());
        schedulePatternLines = getPatternlineOnDate(date,schedulePatternLines);
        schedulePatternLines.stream().forEach(x -> fillSchedulePatternLine(contractContractLine.getContract().getId(), date, x));
*/
    }

/*    public void fillSchedulePatternLine(Integer contractID, LocalDate date, SchedulePatternLine schedulePatternLine){
        fillEmployeeScheduleLines(contractID, date,schedulePatternLine.getShiftCodeID());
        //System.out.println(employeeScheduleLines);
    }*/


/*    public List<SchedulePatternLine> getPatternlineOnDate(LocalDate date, List<SchedulePatternLine> schedulePatternLines) {
        LocalDate patternFirstDate = getPatternFirstDate(schedulePatternLines);
        Long diff = Math.abs(DAYS.between(date, patternFirstDate));
        Long patternLineNo = diff % getPatternDuration(schedulePatternLines);
        LocalDate patternLineDate = DAYS.addTo(patternFirstDate, patternLineNo);
        return schedulePatternLines
                .stream()
                .filter(x -> x.getInitialDate().isEqual(patternLineDate))
                .collect(Collectors.toList());
    }*/

/*    public LocalDate getPatternFirstDate(List<SchedulePatternLine> schedulePatternLines) {
        return schedulePatternLines
                .stream()
                .min(Comparator.comparing(SchedulePatternLine::getInitialDate))
                .get().getInitialDate();
    }*/

/*    private int getPatternDuration(List<SchedulePatternLine> schedulePatternLines) {
        return (int) schedulePatternLines
                .stream()
                .map(x -> x.getInitialDate())
                .distinct().count();
    }*/

    public void fillEmployeeScheduleLines(Integer contractID, LocalDate date, String shift) {
        codeDAO
                .findShiftLines(shift)
                .stream()
                .forEach(x -> fillEmployeeScheduleLine(contractID, date, x));
                //.collect(Collectors.toList());
    }

    private void fillEmployeeScheduleLine(Integer contractID, LocalDate date, ShiftLine shiftLine) {
        LocalDateTime startDateTime = LocalDateTime.of(date, shiftLine.getBegin());
        LocalDateTime endDateTime;
        if (shiftLine.getBegin().isBefore(shiftLine.getEnd())) {
            endDateTime = LocalDateTime.of(date, shiftLine.getEnd());
        } else endDateTime = LocalDateTime.of(date.plusDays(1), shiftLine.getEnd());

        EmployeeScheduleLine employeeScheduleLine= new EmployeeScheduleLine(
                employee.getId(),
                contractID,
                shiftLine.getShiftCodeID(),
                shiftLine.getTimeCodeID(),
                startDateTime,
                endDateTime);

        //return employeeScheduleLine;

        employeeScheduleLineDAO.createEmployeeScheduleLine(employeeScheduleLine);

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
