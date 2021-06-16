package edu.tests.employee;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

class EmployeeRepositoryTest {

    @Test
    public void createEmpoloyeeTest(){
        Connection conn = Mockito.mock(Connection.class);
        try(PreparedStatement stmt = Mockito.mock(PreparedStatement.class)){
            Mockito.when(conn.prepareStatement(Mockito.anyString())).thenReturn(stmt);
            //EmployeeDAO2 employeeDAO = new EmployeeDAOImpl(conn);
            //Employee employee = new Employee("Jonas", "Jonukas", "Jonaitis");
            //employeeDAO.createEmployee(employee);

            Mockito.verify(stmt).setString(1, "Jonas");
            Mockito.verify(stmt).setString(2, "Jonukas");
            Mockito.verify(stmt).setString(3, "Jonaitis");
            Mockito.verify(stmt).execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

