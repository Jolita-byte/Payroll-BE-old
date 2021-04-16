package service;

import entity.*;
import DAO.*;

//import employee.ContractContractLine;
//import employee.ContractDAO;
//import employee.Employee;
//import general.CodeDAO;
//import schedule.dao.EmployeeScheduleLineDAO;
//import schedule.dao.SchedulePatternLineDAO;
//import schedule.entity.EmployeeScheduleLine;
//import schedule.entity.ShiftLine;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ScheduleService {
    //private final Employee employee;
    private final ContractDAO contractDAO;
    private final ContractLineDAO contractLineDAO;
    //private final CodeDAO codeDAO;
    private final SchedulePatternLineDAO schedulePatternLineDAO;
    private final ShiftLineDAO shiftLineDAO;
    private final EmployeeScheduleEntryDAO employeeScheduleEntryDAO;
    private List<EmployeeScheduleEntry> employeeScheduleEntries;
    //private final ShiftLineDAO shiftLineDAO;


    public ScheduleService(ContractDAO contractDAO, ContractLineDAO contractLineDAO,SchedulePatternLineDAO schedulePatternLineDAO, ShiftLineDAO shiftLineDAO,EmployeeScheduleEntryDAO employeeScheduleEntryDAO) {
        //this.employee = employee;
        this.contractDAO = contractDAO;
        this.contractLineDAO = contractLineDAO;
        this.schedulePatternLineDAO = schedulePatternLineDAO;
        this.shiftLineDAO = shiftLineDAO;
        this.employeeScheduleEntryDAO = employeeScheduleEntryDAO;
        this.employeeScheduleEntries = new ArrayList<>();
    }

    public void fillContractSchedule(Contract contract, LocalDate begin, LocalDate end) {
        for (LocalDate i = begin; (i.isBefore(end) || i.isEqual(end)); i = i.plusDays(1)) {
            System.out.println(contractLineDAO.findValidOnDate(contract.getId(),i));
            //ContractLine contractLine = contractLineDAO.findValidOnDate(contract.getId(),i);
            //SchedulePatternLine schedulePatternLine = schedulePatternLineDAO.findValidOnDate(contractLine.getSchedule_code().getId(),i);
            //ShiftLine shiftLine = shiftLineDAO.findValidOnDate(schedulePatternLine.getShift_code().getId(),i);


            /**LocalDate finalI = i;

            contractDAO
                    .findEmployeeContractContractLinesByDate(employeeID, i)
                    .stream()
                    .forEach(x -> fillContractSchedule(finalI, x));*/
        }
    }

   /** public void fillContractSchedule(LocalDate date, ContractContractLine contractContractLine) {
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
/**
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

        EmployeeScheduleEntry employeeScheduleLine = new EmployeeScheduleEntry(
                contractID,
                shiftLine.getShiftCodeID(),
                shiftLine.getTimeCodeID(),
                startDateTime,
                endDateTime);

        //return employeeScheduleLine;

        employeeScheduleLineDAO.createEmployeeScheduleLine(employeeScheduleLine);

    }*/


