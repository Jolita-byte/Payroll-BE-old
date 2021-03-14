//import static Calculations.Average.calculateAverage;

import employee.Employee;
import employee.*;
import general.Code;
import general.CodeDAO;
import general.CodeDAOImpl;
import payrollConnections.PayrollConnection;
import schedule.ScheduleService;
import schedule.dao.*;
import schedule.entity.EmployeeScheduleLine;
import schedule.entity.SchedulePatternLine;
import schedule.entity.ShiftLine;


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
          try (Connection conn = PayrollConnection.getConnection())  {

              //ContractDAO contractDAO = new ContractDAOImpl(conn);

              //ScheduleFunctions.fillSchedule(2,)


              //insertCodes(conn);

              //insertEmployee(conn);


              //insertContract(conn);

              //updateContract(conn);
                insertEmployeeScheduleLine(conn);


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

    private static void insertSchedule(Connection conn) {
        CodeDAO scheduleDAO = new CodeDAOImpl(conn, "SCHEDULE_CODE");
        scheduleDAO.createCode(new Code("A5", "8 valandų per dieną, 5 dienų per savaitę"));
        scheduleDAO.createCode(new Code("PAM_D", "Dieninė pamaina"));
    }

    private static void insertScheduleLines(Connection conn) {
        SchedulePatternLineDAO schedulePatternLineDAO = new SchedulePatternLineDAOImpl(conn);
        schedulePatternLineDAO.createSchedulePatternLine(new SchedulePatternLine("A5", LocalDate.of(2021,1,4),"A"));
        schedulePatternLineDAO.createSchedulePatternLine(new SchedulePatternLine("A5", LocalDate.of(2021,1,5),"A"));
        schedulePatternLineDAO.createSchedulePatternLine(new SchedulePatternLine("A5", LocalDate.of(2021,1,6),"A"));
        schedulePatternLineDAO.createSchedulePatternLine(new SchedulePatternLine("A5", LocalDate.of(2021,1,7),"A"));
        schedulePatternLineDAO.createSchedulePatternLine(new SchedulePatternLine("A5", LocalDate.of(2021,1,8),"A"));
        schedulePatternLineDAO.createSchedulePatternLine(new SchedulePatternLine("A5", LocalDate.of(2021,1,9),"P"));
        schedulePatternLineDAO.createSchedulePatternLine(new SchedulePatternLine("A5", LocalDate.of(2021,1,10),"P"));

        schedulePatternLineDAO.createSchedulePatternLine(new SchedulePatternLine("PAM_D", LocalDate.of(2021,1,4),"D12"));
        schedulePatternLineDAO.createSchedulePatternLine(new SchedulePatternLine("PAM_D", LocalDate.of(2021,1,5),"D12"));
        schedulePatternLineDAO.createSchedulePatternLine(new SchedulePatternLine("PAM_D", LocalDate.of(2021,1,6),"N12"));
        schedulePatternLineDAO.createSchedulePatternLine(new SchedulePatternLine("PAM_D", LocalDate.of(2021,1,7),"N12"));
        schedulePatternLineDAO.createSchedulePatternLine(new SchedulePatternLine("PAM_D", LocalDate.of(2021,1,8),"P"));
        schedulePatternLineDAO.createSchedulePatternLine(new SchedulePatternLine("PAM_D", LocalDate.of(2021,1,9),"P"));
        schedulePatternLineDAO.createSchedulePatternLine(new SchedulePatternLine("PAM_D", LocalDate.of(2021,1,10),"P"));
        schedulePatternLineDAO.createSchedulePatternLine(new SchedulePatternLine("PAM_D", LocalDate.of(2021,1,11),"P"));
    }

    private static void insertTimeCode(Connection conn){
        CodeDAO TimeCodeDAO = new CodeDAOImpl(conn, "TIME_CODE");
        TimeCodeDAO.createCode(new Code("DD", "Darbas dieną"));
        TimeCodeDAO.createCode(new Code("DN", "Darbas naktį"));
        TimeCodeDAO.createCode(new Code("VD", "Viršvalandinis darbas"));
        TimeCodeDAO.createCode(new Code("DP", "Darbas Poilsio dieną"));
        TimeCodeDAO.createCode(new Code("DS", "Darbas Šventinę dieną"));
        TimeCodeDAO.createCode(new Code("A", "Kasmetinės atostogos"));
        TimeCodeDAO.createCode(new Code("M", "Papildoma poilsio diena auginatiems vaikus"));
        TimeCodeDAO.createCode(new Code("P", "Poilsis"));
        TimeCodeDAO.createCode(new Code("S", "Šventė"));

    }

    private static void insertShiftCode(Connection conn){
        CodeDAO ShiftCodeDAO = new CodeDAOImpl(conn, "SHIFT_CODE");

/*        ShiftCodeDAO.createCode(new Code("A", "Standartinė"));
        ShiftCodeDAO.createCode(new Code("D12", "Dieninė"));
        ShiftCodeDAO.createCode(new Code("N12", "Naktinė"));*/
        ShiftCodeDAO.createCode(new Code("P", "Poilsis"));
    }

    private static void insertShiftLine(Connection conn){
        ShiftLineDAO shiftLineDAO = new ShiftLineDAOImpl(conn);
/*
        shiftLineDAO.createShiftLine(new ShiftLine("A", "DD", LocalTime.of(8,0), LocalTime.of(12,0)));
        shiftLineDAO.createShiftLine(new ShiftLine("A", "DD", LocalTime.of(13,0), LocalTime.of(17,0)));
        shiftLineDAO.createShiftLine(new ShiftLine("D12", "DD", LocalTime.of(6,30), LocalTime.of(18,30)));
        shiftLineDAO.createShiftLine(new ShiftLine("N12", "DD", LocalTime.of(18,30), LocalTime.of(6,30)));
        shiftLineDAO.createShiftLine(new ShiftLine("N12", "DN", LocalTime.of(22,0), LocalTime.of(6,0)));
*/
        shiftLineDAO.createShiftLine(new ShiftLine("P", "P", LocalTime.of(0,0), LocalTime.of(0,0)));

    }

    private static void insertEmployeeScheduleLine(Connection conn){
        EmployeeDAO employeeDAO = new EmployeeDAOImpl(conn);
        CodeDAO codeDAO = new CodeDAOImpl(conn, "SHIFT_CODE");
        //CodeDAO scheduleCode = new CodeDAOImpl(conn, "SCHEDULE_CODE");
        //ShiftLineDAO shiftLineDAO = new ShiftLineDAOImpl(conn);
        SchedulePatternLineDAO schedulePatternLineDAO = new SchedulePatternLineDAOImpl(conn);
        List<SchedulePatternLine> schedulePatternLinesA5 = schedulePatternLineDAO.getAllSchedulePatternLines("A5");


        EmployeeScheduleLineDAO employeeScheduleLineDAO = new EmployeeScheduleLineDAOImpl(conn);
        ScheduleService scheduleService = new ScheduleService(employeeDAO.readEmployee(2), codeDAO, employeeScheduleLineDAO);
        //List<EmployeeScheduleLine> employeeScheduleLines = scheduleService.fillEmployeeScheduleLines(LocalDate.of(2021,01,07), codeDAO.readCode("N12"));
        //System.out.println(scheduleService.getPatternFirstDate(schedulePatternLinesA5));
        List<SchedulePatternLine> patternLine = scheduleService.getPatternline(LocalDate.of(2021, 03, 12), schedulePatternLinesA5);
        System.out.println(patternLine);
        //employeeScheduleLines.forEach(x -> employeeScheduleLineDAO.createEmployeeScheduleLine(x));
        //employeeScheduleLineDAO.createEmployeeScheduleLine(employeeScheduleLine1);
        //employeeScheduleLineDAO.createEmployeeScheduleLine(new EmployeeScheduleLine(2, "A", "DD", LocalDateTime.of(2021, 1, 2, 8,0, 0), LocalDateTime.of(2021, 1, 2, 12,0, 0)));
        //employeeScheduleLineDAO.createEmployeeScheduleLine(new EmployeeScheduleLine(2, "A", "DD", LocalDateTime.of(2021, 1, 2, 13,0, 0), LocalDateTime.of(2021, 1, 2, 17,0, 0)));

    }

}
