package employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDAOImpl implements EmployeeDAO {
    private final Connection connection;

    public EmployeeDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createEmployee(Employee employee) {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO  EMPLOYEE (Name, SecondName, Surname) VALUES (?, ?, ?)")) {
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getSecondName());
            statement.setString(3, employee.getSurname());
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void readEmployee(Integer id) {

    }

    @Override
    public void updateEmployee(Integer id, Employee employee) {

    }

    @Override
    public void deleteEmployee(Integer id) {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM EMPLOYEE WHERE id = ?")){
            statement.setInt(1, id);
            statement.execute();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
