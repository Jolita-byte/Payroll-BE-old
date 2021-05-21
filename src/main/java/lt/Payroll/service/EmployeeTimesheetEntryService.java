package lt.Payroll.service;

import lt.Payroll.model.EmployeeTimesheetEntry;
import lt.Payroll.repository.EmployeeTimesheetEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeTimesheetEntryService {
    @Autowired
    private EmployeeTimesheetEntryRepository employeeTimesheetEntryRepository;


    public List<EmployeeTimesheetEntry> getAllEmployeeTimesheetEntries() {
        return employeeTimesheetEntryRepository.findAll();
    }
}
