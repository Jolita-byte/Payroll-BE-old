package lt.Payroll.controller;

import lt.Payroll.model.EmployeeAmount;
import lt.Payroll.service.EmployeeAmountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/employeeAmounts")
public class EmployeeAmountController {
    @Autowired
    private EmployeeAmountService employeeAmountService;

    @GetMapping
    public List<EmployeeAmount> getAllEmployeeAmounts(){
        return employeeAmountService.getAllEmployeeAmounts();
    }
}
