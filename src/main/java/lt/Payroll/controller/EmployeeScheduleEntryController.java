package lt.Payroll.controller;

import lt.Payroll.model.EmployeeScheduleEntry;
import lt.Payroll.service.EmployeeScheduleEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/employeeScheduleEntries")
public class EmployeeScheduleEntryController {
    @Autowired
    private EmployeeScheduleEntryService employeeScheduleEntryService;

    @GetMapping
    public List<EmployeeScheduleEntry> getAllEmployeeScheduleEntries(){
        return employeeScheduleEntryService.getAllEmployeeScheduleEntries();
    }
}
