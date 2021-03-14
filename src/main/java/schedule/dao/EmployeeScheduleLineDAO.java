package schedule.dao;

import schedule.entity.EmployeeScheduleLine;
import schedule.entity.ShiftLine;

import java.util.Optional;

public interface EmployeeScheduleLineDAO {
    void createEmployeeScheduleLine(EmployeeScheduleLine employeeScheduleLine);
    Optional<EmployeeScheduleLine> readEmployeeScheduleLine(Integer id);
    void updateEmployeeScheduleLine(Integer id, EmployeeScheduleLine employeeScheduleLine);
    void deleteEmployeeScheduleLine(Integer id);
}
