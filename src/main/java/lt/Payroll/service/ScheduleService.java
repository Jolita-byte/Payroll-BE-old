package lt.Payroll.service;

import lt.Payroll.model.*;
import lt.Payroll.model.requestbody.FillScheduleRequest;
import lt.Payroll.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class ScheduleService {
    @Autowired
    private ContractLineRepository contractLineRepository;
    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private SchedulePatternLineRepository schedulePatternLineRepository;
    @Autowired
    private ShiftLineRepository shiftLineRepository;
    @Autowired
    private EmployeeScheduleEntryRepository employeeScheduleEntryRepository;

    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public List<SchedulePatternLine> getAllPatternLines() {
        return schedulePatternLineRepository.findAll();
    }

    public List<EmployeeScheduleEntry> fillSchedule(FillScheduleRequest fillScheduleRequest) {
        List<EmployeeScheduleEntry> employeeScheduleEntries = new ArrayList<>();
        List<Long> contractIdList = fillScheduleRequest.getContract_id_list();
        for (Long contractId : contractIdList) {
            employeeScheduleEntries.addAll(generateEmployeeScheduleEntriesByContractFromToDate(contractId,
                    fillScheduleRequest.getFrom(), fillScheduleRequest.getTo()));
        }
        return employeeScheduleEntries;
    }

    private List<EmployeeScheduleEntry> generateEmployeeScheduleEntriesByContractFromToDate(Long contract_id, LocalDate from, LocalDate to) {
        List<EmployeeScheduleEntry> employeeScheduleEntries = new ArrayList<>();
        for (LocalDate date = from; (date.isBefore(to) || date.isEqual(to)); date = date.plusDays(1)) {
            ContractLine contractLine = contractLineRepository.findValidOnDate(contract_id, date);
            List<ShiftLine> shiftLinesOnDate = getShiftLinesByContractOnDate(date, contractLine);
            employeeScheduleEntries.addAll(generateEmployeeScheduleEntriesOnDate(date, contractLine, shiftLinesOnDate));
        }
        return employeeScheduleEntries;
    }

    private List<ShiftLine> getShiftLinesByContractOnDate(LocalDate date, ContractLine contractLine) {
        Schedule schedule = contractLine.getSchedule();
        LocalDate firstPatternLineDate = schedulePatternLineRepository.findFirstByScheduleOrderByInitialDate(schedule).getInitialDate();
        int patternLength = schedulePatternLineRepository.findAllBySchedule(schedule).size();
        Long diff = Math.abs(DAYS.between(date, firstPatternLineDate));
        Long patternLineOnDate = diff % patternLength;
        LocalDate DateOfPatternLine = DAYS.addTo(firstPatternLineDate, patternLineOnDate);
        List<SchedulePatternLine> patternlinesOnDate = schedulePatternLineRepository.findAllByScheduleAndInitialDate(schedule, DateOfPatternLine);

        List<ShiftLine> shiftLinesOnDate = new ArrayList<>();
        for (SchedulePatternLine s : patternlinesOnDate) {
            List<ShiftLine> shiftLines = shiftLineRepository.findAllByShift(s.getShift());
            shiftLinesOnDate.addAll(shiftLines);
        }
        return shiftLinesOnDate;
    }

    private List<EmployeeScheduleEntry> generateEmployeeScheduleEntriesOnDate(LocalDate date, ContractLine contractLine, List<ShiftLine> shiftLinesOnDate) {
        List<EmployeeScheduleEntry> employeeScheduleEntries = new ArrayList<>();
        for (ShiftLine s : shiftLinesOnDate) {
            EmployeeScheduleEntry employeeScheduleEntry = new EmployeeScheduleEntry();
            employeeScheduleEntry.setContract(contractLine.getId().getContract());
            employeeScheduleEntry.setShift(s.getShift());
            employeeScheduleEntry.setActivityCode(s.getActivityCode());

            LocalDateTime startDateTime = LocalDateTime.of(date, s.getStart());
            employeeScheduleEntry.setStartDateTime(startDateTime);

            LocalDateTime endDateTime;
            if (s.getStart().isBefore(s.getEnd())) {
                endDateTime = LocalDateTime.of(date, s.getEnd());
            } else endDateTime = LocalDateTime.of(date.plusDays(1), s.getEnd());

            employeeScheduleEntry.setEndDateTime(endDateTime);

            employeeScheduleEntries.add(employeeScheduleEntry);
            employeeScheduleEntryRepository.save(employeeScheduleEntry);
        }
        return employeeScheduleEntries;
    }
}
