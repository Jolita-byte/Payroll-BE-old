package lt.Payroll.controller;

import lt.Payroll.model.EmployeeTimesheetEntry;
import lt.Payroll.service.EmployeeTimesheetEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/employeeTimesheetEntries")
public class EmployeeTimesheetEntryController {
    @Autowired
    private EmployeeTimesheetEntryService employeeTimesheetEntryService;

    @GetMapping
    public List<EmployeeTimesheetEntry> getAllEmployeeTimesheetEntries(){
        return employeeTimesheetEntryService.getAllEmployeeTimesheetEntries();
    }
}
