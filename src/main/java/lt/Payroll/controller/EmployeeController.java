package lt.Payroll.controller;

import lt.Payroll.model.Employee;
import lt.Payroll.model.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lt.Payroll.service.EmployeeService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public Employee postEmployee(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.postEmployee(employeeDTO);
    }
}
