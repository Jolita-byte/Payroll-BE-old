package lt.Payroll.service;

import lt.Payroll.model.EmployeeAmount;
import lt.Payroll.repository.EmployeeAmountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeAmountService {
    @Autowired
    private EmployeeAmountRepository employeeAmountRepository;

    public List<EmployeeAmount> getAllEmployeeAmounts() {
        return employeeAmountRepository.findAll();
    }
}
