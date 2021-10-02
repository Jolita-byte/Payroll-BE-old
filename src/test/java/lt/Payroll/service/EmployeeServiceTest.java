package lt.Payroll.service;

import lt.Payroll.model.Employee;
import lt.Payroll.repository.EmployeeRepository;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.BDDAssumptions.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class EmployeeServiceTest {

    @InjectMocks
    EmployeeService employeeService;

    @Mock
    EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllEmployeesTest() {
        List<Employee> employeeList = new ArrayList<>();
        Employee employee1 = new Employee();
        employee1.setId(1L);
        employee1.setName("Jonas");
        employee1.setSecond_name("Jonukas");
        employee1.setSurname("Jonaitis");

        Employee employee2 = new Employee();
        employee1.setId(2L);
        employee1.setName("Petras");
        employee1.setSecond_name("Petriukas");
        employee1.setSurname("Petraitis");

        employeeList.addAll(Arrays.asList(employee1, employee2));

        when(employeeRepository.findAll()).thenReturn(employeeList);

        List<Employee> result = employeeService.getAllEmployees();

        assertNotNull(result);
        //assertEquals("Jonas", );

        //verify(employeeRepository, times(1)).findAll().equals(employeeList);
    }

    @Test
    void postEmployee() {
    }
}
