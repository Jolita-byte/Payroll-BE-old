package lt.Payroll.schedule.dao;

import lt.Payroll.schedule.entity.EmployeeScheduleLine;

import java.sql.*;
import java.util.Optional;

public class EmployeeScheduleLineDAOImpl implements EmployeeScheduleLineDAO {
    private final Connection connection;

    public EmployeeScheduleLineDAOImpl(Connection connection) {
        this.connection = connection;
    }
    @Override
    public void createEmployeeScheduleLine(EmployeeScheduleLine employeeScheduleLine) {
        String sql = "INSERT INTO EMPLOYEE_SCHEDULE_ENTRY (" +
                "Employee_ID," +
                "Contract_ID, " +
                "Shift_Code_ID, " +
                "Time_Code_ID, " +
                "StartDateTime, " +
                "EndDateTime" +
                ") VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, employeeScheduleLine.getEmployeeID());
            statement.setInt(2, employeeScheduleLine.getContractID());
            statement.setString(3, employeeScheduleLine.getShiftCodeID());
            statement.setString(4, employeeScheduleLine.getTimeCodeID());
            statement.setTimestamp(5, Timestamp.valueOf(employeeScheduleLine.getStartDateTime()));
            statement.setTimestamp(6, Timestamp.valueOf(employeeScheduleLine.getEndDateTime()));
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Optional<EmployeeScheduleLine> readEmployeeScheduleLine(Integer id) {
        return Optional.empty();
    }

    @Override
    public void updateEmployeeScheduleLine(Integer id, EmployeeScheduleLine employeeScheduleLine) {

    }

    @Override
    public void deleteEmployeeScheduleLine(Integer id) {

    }
}
