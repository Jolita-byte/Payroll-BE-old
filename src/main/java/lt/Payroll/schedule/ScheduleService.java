package lt.Payroll.schedule;

import lt.Payroll.employee.ContractContractLine;
import lt.Payroll.employee.ContractDAO;
import lt.Payroll.employee.Employee;
import lt.Payroll.general.CodeDAO;
import lt.Payroll.schedule.dao.EmployeeScheduleLineDAO;
import lt.Payroll.schedule.dao.SchedulePatternLineDAO;
import lt.Payroll.schedule.entity.EmployeeScheduleLine;
import lt.Payroll.schedule.entity.ShiftLine;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


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
     * function fills lt.Payroll.time lt.Payroll.schedule for specified lt.Payroll.employee for specipied period of lt.Payroll.time
     * - loop trough each day in the period
     * - find Employee contracts in each day
     * - loop trough contracts to fill lt.Payroll.schedule for each cotract
     * - find lt.Payroll.time lt.Payroll.schedule for specified contract and day
     * - find pattern lines for specified day and lt.Payroll.schedule
     * - find shift lines for specified shift
     * - create Employee Schedule lines for each shift line
     */

    /*



     * search for lt.Payroll.employee

     */
}
