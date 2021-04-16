//package payrollConnections;
//
////import com.mysql.jdbc.Driver;
//import org.h2.Driver;
//import org.mockito.Mockito;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class PayrollConnection {
//
//    private static final String URL = "jdbc:mysql://localhost:3306/payroll";
//    private static final String USER = "root";
//    private static final String PASS = "Jolita4*";
//
//    /**
//     * Get a connection to database
//     * @return Connection object
//     */
//    public static Connection getConnection()
//    {
//        try {
//            DriverManager.registerDriver(new Driver());
//            return DriverManager.getConnection(URL, USER, PASS);
//        } catch (SQLException ex) {
//            throw new RuntimeException("Error connecting to the database", ex);
//        }
//    }
//
//    public static Connection getMockConnection(){
//        return Mockito.mock(Connection.class);
//    }
//
//    /**
//     * Test Connection
//     */
//    public static void main(String[] args) {
//        Connection connection = PayrollConnection.getConnection();
//    }
//
//}
//
//
//
//
//
//
///*
//package Connection;
//
//public final class PayrollConnection {
//    private static final String URL = "jdbc:mysql://localhost:3306/payroll";
//    private static final String USER = "root";
//    private static final String PASSWORD = "Jolita4*";
//
//    public static String getURL() {
//        return URL;
//    }
//
//    public static String getUSER() {
//        return USER;
//    }
//
//    public static String getPASSWORD() {
//        return PASSWORD;
//    }
//}
//*/
