package Employee;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

class EmployeeDAOTest {

    @Test
    public void createEmpoloyeeTest(){
        Connection conn = Mockito.mock(Connection.class);
        try(PreparedStatement stmt = Mockito.mock(PreparedStatement.class)){
            Mockito.when(conn.prepareStatement(Mockito.anyString())).thenReturn(stmt);
            EmployeeDAO employeeDAO = new EmployeeDAOImpl(conn);
            Employee employee = new Employee("Jonas", "Jonukas", "Jonaitis");
            employeeDAO.createEmployee(employee);

            Mockito.verify(stmt).setString(1, "Jonas");
            Mockito.verify(stmt).setString(2, "Jonukas");
            Mockito.verify(stmt).setString(3, "Jonaitis");
            Mockito.verify(stmt).execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
//EmployeeDAO employeeDAO = new EmployeeDAOImpl(Mockito.mock(Connection.class));
//Employee employee = new Employee("Jonas", "Jonukas", "Jonaitis");

//employeeDAO.createEmployee(employee);
// assertThat(???);
    //assertEntityCreatedInDB(employee);
//Mockito.verify(employeeDAO, Mockito.times(1)).createEmployee(employee);

        //Connection conn = PayrollConnection.getMockConnection();

/*        TipoUsuario tipoUsuario = new TipoUsuario(1, "Mantenedor", "AC2354", true);
        //Instance of my class where I have my insert, update and delete methods
        Utilidades instance = new Utilidades();
        //I mock an entity manager with annotation @Mock and I pass that mocked entitytmanager to my the entitymanager that I have in my main class
        instance.em = this.em;
        //and that's all i got.. I don't know how to test if it really works
        //i send my entity to my methor insert
        instance.insert(tipoUsuario);
        //i dont know what is return o how to use the assertEquals in this case...
        assertEquals( ?,  ?);
        Mockito.verify(em, Mockito.times(1)).persist(tipoUsuario);*/

       /* //Connection conn = DriverManager.getConnection(PayrollConnection.getURL(), PayrollConnection.getUSER(), PayrollConnection.getPASSWORD())
        //Connection connection = getConnection();
        conn.setAutoCommit(false);    //begin transaction

        try{
            employeeDAO.createEmployee(new Employee(1, "Jonas", "Petras", "Jonaitis"));
            employeeDAO.createEmployee(new Employee("Jonas", "Petras", "Jonaitis"));
            myDao.insertABC("1", "one");
            myDao.insertABC("2", "two");

            assertEquals("one", myDao.readABC("1"));
            assertEquals("two", myDao.readABC("2"));


            myDao.update("1", "oneOne");
            myDao.update("2", "twoTwo");

            assertEquals("oneOne", myDao.readABC("1"));
            assertEquals("twoTwo", myDao.readABC("2"));


            myDao.delete("1");
            myDao.delete("2");

            assertNull(myDao.readABC("1"));
            assertNull(myDao.readABC("2"));


        } finally {
            connection.rollback();
            connection.close();
        }*/