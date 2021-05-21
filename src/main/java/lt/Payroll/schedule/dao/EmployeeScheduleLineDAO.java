package lt.Payroll.schedule.dao;

import lt.Payroll.schedule.entity.EmployeeScheduleLine;

import java.util.Optional;

public interface EmployeeScheduleLineDAO {
    void createEmployeeScheduleLine(EmployeeScheduleLine employeeScheduleLine);
    Optional<EmployeeScheduleLine> readEmployeeScheduleLine(Integer id);
    void updateEmployeeScheduleLine(Integer id, EmployeeScheduleLine employeeScheduleLine);
    void deleteEmployeeScheduleLine(Integer id);
}
