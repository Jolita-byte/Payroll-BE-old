//import static Calculations.Average.calculateAverage;

import Employee.Employee;
import Employee.*;
import General.Code;
import General.CodeDAO;
import General.CodeDAOImpl;
import PayrollConnections.PayrollConnection;


import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    //private static final String URL = "jdbc:mysql://localhost:3306/payroll";
    //private static final String USER = "root";
    //private static final String PASSWORD = "Jolita4*";


    public static void main(String[] args) throws ClassNotFoundException {

        //Class.forName("org.h2.Driver"); //pasitikrinam
        //try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
        //try (Connection conn = DriverManager.getConnection(PayrollConnection.getURL(), PayrollConnection.getUSER(), PayrollConnection.getPASSWORD())){
          try (Connection conn = PayrollConnection.getConnection())  {
              //insertEmployee(conn);
              //insertSchedule(conn);

              insertContract(conn);

              //updateContract(conn);


          } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
/*        AmountCode ATL_DD = new AmountCode("ATL DD", AmountCode.Type.EARNING);
        AmountCode ATL_DD2 = new AmountCode("ATL DD", AmountCode.Type.EARNING);
        System.out.println(ATL_DD.equals(ATL_DD2));
        AmountCode.Type a = AmountCode.Type.EARNING;
        AmountCode.Type b = AmountCode.Type.EARNING;
        System.out.println(a.equals(b));*/
    }

    private static void updateContract(Connection conn) {
        ContractDAO contractDAO = new ContractDAOImpl(conn);

        ContractLine contractLine2 = new ContractLine(null,null,null,null,1700f);

        contractDAO.updateContract(2, LocalDate.of(2021, 05, 10), contractLine2);
    }

    private static void insertContract(Connection conn) {
        ContractDAO contractDAO = new ContractDAOImpl(conn);

        Contract contract = new Contract(2,LocalDate.of(2021,01,15), LocalDate.of(2021,01,10), null);
        ContractLine contractLine = new ContractLine(LocalDate.of(2021,01,15),"A5", "INZ", 1, ContractLine.AmountType.MONTHLY, 2000f);


        contractDAO.createContract(contract, contractLine);
    }

    private static void insertSchedule(Connection conn) {
        CodeDAO scheduleDAO = new CodeDAOImpl(conn, "SCHEDULE_CODE");
        scheduleDAO.createCode(new Code("PAM_D", "Dieninė pamaina"));
    }

    private static void insertEmployee(Connection conn) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl(conn);

        employeeDAO.createEmployee(new Employee("Pirmas", "", "Pirmokas" ));
        employeeDAO.createEmployee(new Employee("Antras", "", "Antrokas" ));
        employeeDAO.createEmployee(new Employee("Trečias", "", "Trečiokas" ));
        employeeDAO.createEmployee(new Employee("Ketvirtas", "", "Ketvirtokas" ));
        employeeDAO.createEmployee(new Employee("Penktas", "", "Penktokas" ));
        employeeDAO.createEmployee(new Employee("Šeštas", "", "Šeštokas" ));
        employeeDAO.createEmployee(new Employee("Septintas", "", "Septintokas" ));
        employeeDAO.createEmployee(new Employee("Aštuntas", "", "Aštuntokas" ));
        employeeDAO.createEmployee(new Employee("Devintas", "", "Devintokas" ));
        employeeDAO.createEmployee(new Employee("Dešimtas", "", "Dešimtokas" ));
    }
}
