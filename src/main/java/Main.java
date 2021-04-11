//import static Calculations.Average.calculateAverage;

import DAO.*;
import entity.*;
import payrollConnections.PayrollConnection;
/*import general.Code;
import general.CodeDAO;
import general.CodeDAOImpl;

import schedule.ScheduleService;
import schedule.dao.*;
import schedule.entity.EmployeeScheduleLine;
import schedule.entity.SchedulePatternLine;
import schedule.entity.ShiftLine;*/


import javax.persistence.EntityManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

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

        generate(em);

        //read();



/*        AmountCode ATL_DD = new AmountCode("ATL DD", AmountCode.Type.EARNING);
        AmountCode ATL_DD2 = new AmountCode("ATL DD", AmountCode.Type.EARNING);
        System.out.println(ATL_DD.equals(ATL_DD2));
        AmountCode.Type a = AmountCode.Type.EARNING;
        AmountCode.Type b = AmountCode.Type.EARNING;
        System.out.println(a.equals(b));*/
    }

    private static void generate(EntityManager em){
        //createTimeCodes(em);
        createShiftCodes(em);
        createShiftLines(em);
        createScheduleCodes(em);
        createSchedulePatternLines(em);



    }

    private static void createTimeCodes(EntityManager em){
        TimeCodeDAO timeCodeDAO = new TimeCodeDAO(em);
        timeCodeDAO.create(new TimeCode("DD", "Darbas dieną"));
        timeCodeDAO.create(new TimeCode("DN", "Darbas naktį"));
        timeCodeDAO.create(new TimeCode("VD", "Viršvalandinis darbas"));
        timeCodeDAO.create(new TimeCode("DP", "Darbas Poilsio dieną"));
        timeCodeDAO.create(new TimeCode("DS", "Darbas Šventinę dieną"));
        timeCodeDAO.create(new TimeCode("A", "Kasmetinės atostogos"));
        timeCodeDAO.create(new TimeCode("M", "Papildoma poilsio diena auginatiems vaikus"));
        timeCodeDAO.create(new TimeCode("P", "Poilsis"));
        timeCodeDAO.create(new TimeCode("S", "Šventė"));
    }

    private static void createShiftCodes(EntityManager em){
        ShiftCodeDAO shiftCodeDAO = new ShiftCodeDAO(em);
        shiftCodeDAO.create(new ShiftCode("A", "Standartinė"));
        shiftCodeDAO.create(new ShiftCode("D12", "Dieninė"));
        shiftCodeDAO.create(new ShiftCode("N12", "Naktinė"));
        shiftCodeDAO.create(new ShiftCode("P", "Poilsis"));
    }

    private static void createShiftLines(EntityManager em){
        //reikia Embeded ID
/*        ShiftLineDAO shiftLineDAO = new ShiftLineDAO(em);
        shiftLineDAO.create(new ShiftLine("A", "DD", LocalTime.of(8,0), LocalTime.of(12,0)));
        shiftLineDAO.create(new ShiftLine("A", "DD", LocalTime.of(13,0), LocalTime.of(17,0)));
        shiftLineDAO.create(new ShiftLine("D12", "DD", LocalTime.of(6,30), LocalTime.of(18,30)));
        shiftLineDAO.create(new ShiftLine("N12", "DD", LocalTime.of(18,30), LocalTime.of(6,30)));
        shiftLineDAO.create(new ShiftLine("N12", "DN", LocalTime.of(22,0), LocalTime.of(6,0)));
        shiftLineDAO.create(new ShiftLine("P", "P", LocalTime.of(0,0), LocalTime.of(0,0)));*/
    }

    private static void createScheduleCodes(EntityManager em) {
        ScheduleCodeDAO scheduleCodeDAO = new ScheduleCodeDAO(em);
        scheduleCodeDAO.create(new ScheduleCode("A5", "8 valandų per dieną, 5 dienų per savaitę"));
        scheduleCodeDAO.create(new ScheduleCode("PAM_D", "Dieninė pamaina"));
    }

    private static void createSchedulePatternLines(EntityManager em) {
        /*SchedulePatternLineDAO schedulePatternLineDAO = new SchedulePatternLineDAO(em);
        schedulePatternLineDAO.create(new SchedulePatternLine("A5", LocalDate.of(2021,1,4),"A"));
        schedulePatternLineDAO.create(new SchedulePatternLine("A5", LocalDate.of(2021,1,5),"A"));
        schedulePatternLineDAO.create(new SchedulePatternLine("A5", LocalDate.of(2021,1,6),"A"));
        schedulePatternLineDAO.create(new SchedulePatternLine("A5", LocalDate.of(2021,1,7),"A"));
        schedulePatternLineDAO.create(new SchedulePatternLine("A5", LocalDate.of(2021,1,8),"A"));
        schedulePatternLineDAO.create(new SchedulePatternLine("A5", LocalDate.of(2021,1,9),"P"));
        schedulePatternLineDAO.create(new SchedulePatternLine("A5", LocalDate.of(2021,1,10),"P"));

        schedulePatternLineDAO.create(new SchedulePatternLine("PAM_D", LocalDate.of(2021,1,4),"D12"));
        schedulePatternLineDAO.create(new SchedulePatternLine("PAM_D", LocalDate.of(2021,1,5),"D12"));
        schedulePatternLineDAO.create(new SchedulePatternLine("PAM_D", LocalDate.of(2021,1,6),"N12"));
        schedulePatternLineDAO.create(new SchedulePatternLine("PAM_D", LocalDate.of(2021,1,7),"N12"));
        schedulePatternLineDAO.create(new SchedulePatternLine("PAM_D", LocalDate.of(2021,1,8),"P"));
        schedulePatternLineDAO.create(new SchedulePatternLine("PAM_D", LocalDate.of(2021,1,9),"P"));
        schedulePatternLineDAO.create(new SchedulePatternLine("PAM_D", LocalDate.of(2021,1,10),"P"));
        schedulePatternLineDAO.create(new SchedulePatternLine("PAM_D", LocalDate.of(2021,1,11),"P"));
    */}


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

    private static void insertContract(Connection conn) {
        ContractDAO contractDAO = new ContractDAOImpl(conn);

        Contract contract = new Contract(2,LocalDate.of(2021,01,15), LocalDate.of(2021,01,10), null);
        ContractLine contractLine = new ContractLine(LocalDate.of(2021,01,15),"A5", "INZ", 1, ContractLine.AmountType.MONTHLY, 2000f);


        contractDAO.createContract(contract, contractLine);
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

    public static void insertCodes(Connection conn){
        //insertTimeCode(conn);
        //insertShiftCode(conn);
        //insertShiftLine(conn);
        //insertSchedule(conn);
        //insertScheduleLines(conn);
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
