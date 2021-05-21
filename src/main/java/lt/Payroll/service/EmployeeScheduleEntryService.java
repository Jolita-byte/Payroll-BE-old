package lt.Payroll.service;

import lt.Payroll.model.EmployeeScheduleEntry;
import lt.Payroll.repository.EmployeeScheduleEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeScheduleEntryService {
    @Autowired
    private EmployeeScheduleEntryRepository employeeScheduleEntryRepository;

    public List<EmployeeScheduleEntry> getAllEmployeeScheduleEntries() {
        return employeeScheduleEntryRepository.findAll();
    }
}
