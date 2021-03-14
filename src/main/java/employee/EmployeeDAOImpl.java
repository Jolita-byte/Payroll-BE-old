package employee;

import java.sql.*;
import java.util.Optional;

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
    public Employee readEmployee(Integer id) {
        String sql = "SELECT * FROM EMPLOYEE WHERE ID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            if (!statement.execute()) {
                return null;
            }

            ResultSet resultSet = statement.getResultSet();
            if (resultSet.next()) {
                String name = resultSet.getString("Name");
                String secondName = resultSet.getString("SecondName");
                String surname = resultSet.getString("Surname");
                return new Employee(id, name, secondName, surname);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;

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
