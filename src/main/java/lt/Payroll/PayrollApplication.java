package lt.Payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lt.Payroll.repository.*;
//import lt.Payroll.payrollConnections.PayrollConnection;
import javax.persistence.EntityManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@SpringBootApplication
public class PayrollApplication {
    private static final String URL = "jdbc:mysql://localhost:3306/payroll";
    private static final String USER = "root";
    private static final String PASSWORD = "Jolita4*";


    public static void main(String[] args) throws ClassNotFoundException {

        SpringApplication.run(PayrollApplication.class, args);
        //extracted();
    }

    private static void extracted() {
        //Class.forName("org.h2.Driver"); //pasitikrinam
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
        //try (Connection conn = DriverManager.getConnection(PayrollConnection.getURL(), PayrollConnection.getUSER(), PayrollConnection.getPASSWORD())){
        //try (Connection conn = PayrollConnection.getConnection()) {

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

        //new lt.Payroll.GenerateData().generateAllData(em);

        //read();
        fillschedules();



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
        //AmountCodeRepository amountCodeRepository = new AmountCodeRepository(em);
        //System.out.println(amountCodeRepository.read("ALGA"));
        System.out.println("----Time code--------");
        //ActionRepository actionRepository = new ActionRepository(em);
        //System.out.println(actionRepository.read("DD"));
        System.out.println("----Position code--------");
        //PositionRepository positionRepository = new PositionRepository(em);
        //System.out.println(positionRepository.read("INZ"));
        System.out.println("----Shift code--------");
        //ShiftRepository shiftRepository = new ShiftRepository(em);
        //System.out.println(shiftRepository.read("D12"));


        System.out.println("-----Employee Time Table Entry-------");
        //EmployeeTimesheetEntryRepository employeeTimesheetEntryRepository = new EmployeeTimesheetEntryRepository(em);
        //System.out.println(employeeTimesheetEntryRepository.read(1));
        System.out.println("------------");
        //EmployeeRepository employeeRepository = new EmployeeRepository(em);
        //System.out.println(employeeRepository.read(1));
        System.out.println("------------");
        //ContractRepository contractRepository = new ContractRepository(em);
        //System.out.println(contractRepository.read(1));
        System.out.println("------------");
        //ContractLineRepository contractLineRepository = new ContractLineRepository(em);
        //System.out.println(contractLineRepository.read(new ContractLineID(6, LocalDate.of(2021, 01, 15))));
        System.out.println("------------");
        //EmployeeAmountRepository employeeAmountRepository = new EmployeeAmountRepository(em);
        //Employee employee1 = new Employee(1, "Pirmas","Pirmas", "Pirmokas");
        //A
        //System.out.println(employeeAmountDAO.read(new EmployeeAmountID(employeeRepository.read(1), LocalDate.of(2021, 01, 01), amountCodeDAO.read("ALGA"))));

        System.out.println("------------");
        System.out.println("------------");
        System.out.println("------------");
    }

    private static void fillschedules() {
        HibernateProject hibernateProject = new HibernateProject();
        EntityManager em = hibernateProject.getEntityManager();
        //ContractRepository contractRepository = new ContractRepository(em);
        //ContractLineRepository contractLineRepository = new ContractLineRepository(em);
        //SchedulePatternLineRepository schedulePatternLineRepository = new SchedulePatternLineRepository(em);
        //ShiftLineRepository shiftLineRepository = new ShiftLineRepository(em);
        //EmployeeScheduleEntryRepository employeeScheduleEntryRepository = new EmployeeScheduleEntryRepository(em);

        //ScheduleService2 scheduleService2 = new ScheduleService2(contractDAO, contractLineDAO, schedulePatternLineDAO, shiftLineRepository, employeeScheduleEntryDAO);
        //scheduleService2.fillContractSchedule(contractDAO.read(1), LocalDate.of(2021,01,01), LocalDate.of(2021, 01, 31));


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
