package lt.Payroll.service;

import lt.Payroll.model.Employee;
import lt.Payroll.model.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lt.Payroll.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;


    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee postEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setSecond_name(employeeDTO.getSecond_name());
        employee.setSurname(employeeDTO.getSurname());
        employeeRepository.save(employee);
        return employee;
    }

//    private final EmployeeDAO employeeDAO;
//
//    public EmployeeService(EmployeeDAO employeeDAO) {
//        this.employeeDAO = employeeDAO;
//    }
}
