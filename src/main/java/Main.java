import DAO.*;
import entity.*;
import payrollConnections.PayrollConnection;
import javax.persistence.EntityManager;
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
        try (Connection conn = PayrollConnection.getConnection()) {

            //ContractDAO contractDAO = new ContractDAOImpl(conn);

            //ScheduleFunctions.fillSchedule(2,)


            //insertCodes(conn);

            //insertEmployee(conn);


            //insertContract(conn);

            //updateContract(conn);
            // insertEmployeeScheduleLine(conn);


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        HibernateProject hibernateProject = new HibernateProject();
        EntityManager em = hibernateProject.getEntityManager();

        //new GenerateData().generateAllData(em);

        read();



/*        AmountCode ATL_DD = new AmountCode("ATL DD", AmountCode.Type.EARNING);
        AmountCode ATL_DD2 = new AmountCode("ATL DD", AmountCode.Type.EARNING);
        System.out.println(ATL_DD.equals(ATL_DD2));
        AmountCode.Type a = AmountCode.Type.EARNING;
        AmountCode.Type b = AmountCode.Type.EARNING;
        System.out.println(a.equals(b));*/
    }




    private static void read() {
        HibernateProject hibernateProject = new HibernateProject();
        EntityManager em = hibernateProject.getEntityManager();
        System.out.println("----Amount code--------");
        AmountCodeDAO amountCodeDAO = new AmountCodeDAO(em);
        System.out.println(amountCodeDAO.read("ALGA"));
        System.out.println("----Time code--------");
        TimeCodeDAO timeCodeDAO = new TimeCodeDAO(em);
        System.out.println(timeCodeDAO.read("DD"));
        System.out.println("----Position code--------");
        PositionCodeDAO positionCodeDAO = new PositionCodeDAO(em);
        System.out.println(positionCodeDAO.read("INZ"));
        System.out.println("----Shift code--------");
        ShiftCodeDAO shiftCodeDAO = new ShiftCodeDAO(em);
        System.out.println(shiftCodeDAO.read("D12"));


        System.out.println("-----Employee Time Table Entry-------");
        EmployeeTimeTableEntryDAO employeeTimeTableEntryDAO = new EmployeeTimeTableEntryDAO(em);
        System.out.println(employeeTimeTableEntryDAO.read(1));
        System.out.println("------------");
        EmployeeDAO employeeDAO = new EmployeeDAO(em);
        System.out.println(employeeDAO.read(1));
        System.out.println("------------");
        ContractDAO contractDAO = new ContractDAO(em);
        System.out.println(contractDAO.read(1));
        System.out.println("------------");
        ContractLineDAO contractLineDAO = new ContractLineDAO(em);
        System.out.println(contractLineDAO.read(new ContractLineID(6, LocalDate.of(2021, 01, 15))));
        System.out.println("------------");
        EmployeeAmountDAO employeeAmountDAO = new EmployeeAmountDAO(em);
        //Employee employee1 = new Employee(1, "Pirmas","Pirmas", "Pirmokas");
        //A
        System.out.println(employeeAmountDAO.read(new EmployeeAmountID(employeeDAO.read(1), LocalDate.of(2021, 01, 01), amountCodeDAO.read("ALGA"))));

        System.out.println("------------");
        System.out.println("------------");
        System.out.println("------------");
    }




    /*private static void updateContract(Connection conn) {
        ContractDAO contractDAO = new ContractDAOImpl(conn);

        ContractLine contractLine2 = new ContractLine(null,null,null,null,1700f);

        contractDAO.updateContract(2, LocalDate.of(2021, 05, 10), contractLine2);
    }



    private static void insertEmployeeScheduleLine(Connection conn){
        EmployeeDAO employeeDAO = new EmployeeDAOImpl(conn);
        CodeDAO codeDAO = new CodeDAOImpl(conn, "SHIFT_CODE");
        ContractDAO contractDAO = new ContractDAOImpl(conn);
        //List<ContractContractLine> contractContractLines = contractDAO.findEmployeeContractContractLinesByDate()
        //CodeDAO scheduleCode = new CodeDAOImpl(conn, "SCHEDULE_CODE");
        //ShiftLineDAO shiftLineDAO = new ShiftLineDAOImpl(conn);
        SchedulePatternLineDAO schedulePatternLineDAO = new SchedulePatternLineDAOImpl(conn);
        List<SchedulePatternLine> schedulePatternLinesA5 = schedulePatternLineDAO.getAllSchedulePatternLines("A5");


        EmployeeScheduleLineDAO employeeScheduleLineDAO = new EmployeeScheduleLineDAOImpl(conn);
        ScheduleService scheduleService = new ScheduleService(employeeDAO.readEmployee(2), contractDAO, codeDAO, schedulePatternLineDAO, employeeScheduleLineDAO);
        scheduleService.fillEmployeeSchedule(employeeDAO.readEmployee(2).getId(),LocalDate.of(2021, 1, 1),LocalDate.of(2021, 5, 31));
        //List<EmployeeScheduleLine> employeeScheduleLines = scheduleService.fillEmployeeScheduleLines(LocalDate.of(2021,01,07), codeDAO.readCode("N12"));
        //System.out.println(scheduleService.getPatternFirstDate(schedulePatternLinesA5));
        //List<SchedulePatternLine> patternLine = scheduleService.getPatternlineOnDate(LocalDate.of(2021, 03, 12), schedulePatternLinesA5);
        //System.out.println(patternLine);
        //employeeScheduleLines.forEach(x -> employeeScheduleLineDAO.createEmployeeScheduleLine(x));
        //employeeScheduleLineDAO.createEmployeeScheduleLine(employeeScheduleLine1);
        //employeeScheduleLineDAO.createEmployeeScheduleLine(new EmployeeScheduleLine(2, "A", "DD", LocalDateTime.of(2021, 1, 2, 8,0, 0), LocalDateTime.of(2021, 1, 2, 12,0, 0)));
        //employeeScheduleLineDAO.createEmployeeScheduleLine(new EmployeeScheduleLine(2, "A", "DD", LocalDateTime.of(2021, 1, 2, 13,0, 0), LocalDateTime.of(2021, 1, 2, 17,0, 0)));

    }
*/
}
