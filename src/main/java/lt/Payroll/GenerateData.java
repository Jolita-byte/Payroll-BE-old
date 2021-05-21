/*
package lt.Payroll;

import lt.Payroll.repository.*;
import lt.Payroll.model.*;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.LocalTime;

public class GenerateData {


    public void generateAllData(EntityManager em){
        createTimeCodes(em);
        createShiftCodes(em);
        createShiftLines(em);
        createScheduleCodes(em);
        createSchedulePatternLines(em);
        createPositionCodes(em);
        createAmountCodes(em);
        createEmployees(em);
        createContracts(em);
        createContractLines(em);
    }

    public void createTimeCodes(EntityManager em){
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

    public void createShiftCodes(EntityManager em){
        ShiftCodeDAO shiftCodeDAO = new ShiftCodeDAO(em);
        shiftCodeDAO.create(new ShiftCode("A", "Standartinė"));
        shiftCodeDAO.create(new ShiftCode("D12", "Dieninė"));
        shiftCodeDAO.create(new ShiftCode("N12", "Naktinė"));
        shiftCodeDAO.create(new ShiftCode("P", "Poilsis"));
    }

    public void createShiftLines(EntityManager em){
        ShiftLineDAO shiftLineDAO = new ShiftLineDAO(em);
        shiftLineDAO.create(new ShiftLine(new ShiftCodeDAO(em).read("A"), new TimeCodeDAO(em).read("DD"), LocalTime.of(8,0), LocalTime.of(12,0)));
        shiftLineDAO.create(new ShiftLine(new ShiftCodeDAO(em).read("A"), new TimeCodeDAO(em).read("DD"), LocalTime.of(13,0), LocalTime.of(17,0)));
        shiftLineDAO.create(new ShiftLine(new ShiftCodeDAO(em).read("D12"), new TimeCodeDAO(em).read("DD"), LocalTime.of(6,30), LocalTime.of(18,30)));
        shiftLineDAO.create(new ShiftLine(new ShiftCodeDAO(em).read("N12"), new TimeCodeDAO(em).read("DD"), LocalTime.of(18,30), LocalTime.of(6,30)));
        shiftLineDAO.create(new ShiftLine(new ShiftCodeDAO(em).read("N12"), new TimeCodeDAO(em).read("DN"), LocalTime.of(22,0), LocalTime.of(6,0)));
        shiftLineDAO.create(new ShiftLine(new ShiftCodeDAO(em).read("P"), new TimeCodeDAO(em).read("P"), LocalTime.of(0,0), LocalTime.of(0,0)));
    }

    public void createScheduleCodes(EntityManager em) {
        ScheduleCodeDAO scheduleCodeDAO = new ScheduleCodeDAO(em);
        scheduleCodeDAO.create(new ScheduleCode("A5", "8 valandų per dieną, 5 dienų per savaitę"));
        scheduleCodeDAO.create(new ScheduleCode("PAM_D", "Dieninė pamaina"));
    }

    public static void createSchedulePatternLines(EntityManager em) {
        SchedulePatternLineDAO schedulePatternLineDAO = new SchedulePatternLineDAO(em);
        schedulePatternLineDAO.create(new SchedulePatternLine(new ScheduleCodeDAO(em).read("A5"), LocalDate.of(2021,1,4),new ShiftCodeDAO(em).read("A")));
        schedulePatternLineDAO.create(new SchedulePatternLine(new ScheduleCodeDAO(em).read("A5"), LocalDate.of(2021,1,5),new ShiftCodeDAO(em).read("A")));
        schedulePatternLineDAO.create(new SchedulePatternLine(new ScheduleCodeDAO(em).read("A5"), LocalDate.of(2021,1,6),new ShiftCodeDAO(em).read("A")));
        schedulePatternLineDAO.create(new SchedulePatternLine(new ScheduleCodeDAO(em).read("A5"), LocalDate.of(2021,1,7),new ShiftCodeDAO(em).read("A")));
        schedulePatternLineDAO.create(new SchedulePatternLine(new ScheduleCodeDAO(em).read("A5"), LocalDate.of(2021,1,8),new ShiftCodeDAO(em).read("A")));
        schedulePatternLineDAO.create(new SchedulePatternLine(new ScheduleCodeDAO(em).read("A5"), LocalDate.of(2021,1,9),new ShiftCodeDAO(em).read("P")));
        schedulePatternLineDAO.create(new SchedulePatternLine(new ScheduleCodeDAO(em).read("A5"), LocalDate.of(2021,1,10),new ShiftCodeDAO(em).read("P")));

        schedulePatternLineDAO.create(new SchedulePatternLine(new ScheduleCodeDAO(em).read("PAM_D"), LocalDate.of(2021,1,4),new ShiftCodeDAO(em).read("D12")));
        schedulePatternLineDAO.create(new SchedulePatternLine(new ScheduleCodeDAO(em).read("PAM_D"), LocalDate.of(2021,1,5),new ShiftCodeDAO(em).read("D12")));
        schedulePatternLineDAO.create(new SchedulePatternLine(new ScheduleCodeDAO(em).read("PAM_D"), LocalDate.of(2021,1,6),new ShiftCodeDAO(em).read("N12")));
        schedulePatternLineDAO.create(new SchedulePatternLine(new ScheduleCodeDAO(em).read("PAM_D"), LocalDate.of(2021,1,7),new ShiftCodeDAO(em).read("N12")));
        schedulePatternLineDAO.create(new SchedulePatternLine(new ScheduleCodeDAO(em).read("PAM_D"), LocalDate.of(2021,1,8),new ShiftCodeDAO(em).read("P")));
        schedulePatternLineDAO.create(new SchedulePatternLine(new ScheduleCodeDAO(em).read("PAM_D"), LocalDate.of(2021,1,9),new ShiftCodeDAO(em).read("P")));
        schedulePatternLineDAO.create(new SchedulePatternLine(new ScheduleCodeDAO(em).read("PAM_D"), LocalDate.of(2021,1,10),new ShiftCodeDAO(em).read("P")));
        schedulePatternLineDAO.create(new SchedulePatternLine(new ScheduleCodeDAO(em).read("PAM_D"), LocalDate.of(2021,1,11),new ShiftCodeDAO(em).read("P")));
    }

    public void createPositionCodes(EntityManager em){
        PositionCodeDAO positionCodeDAO = new PositionCodeDAO(em);
        positionCodeDAO.create(new PositionCode("VAD", "Vadovas (-ė)"));
        positionCodeDAO.create(new PositionCode("INZ", "Inžinierius (-ė)"));
        positionCodeDAO.create(new PositionCode("DIR", "Direktorius (-ė)"));
        positionCodeDAO.create(new PositionCode("KON", "Konsultantas (-ė)"));
        positionCodeDAO.create(new PositionCode("BUH", "Buhalteris (-ė)"));
        positionCodeDAO.create(new PositionCode("VADYB", "Vadybininkas (-ė)"));
        positionCodeDAO.create(new PositionCode("PRG", "Programuotojas (-a)"));
        positionCodeDAO.create(new PositionCode("HR", "Personalo vadovas (-ė)"));
        positionCodeDAO.create(new PositionCode("VYR KON", "Vyr. konsultantas (-ė)"));
    }

    public void createAmountCodes(EntityManager em){
        AmountCodeDAO amountCodeDAO = new AmountCodeDAO(em);
        amountCodeDAO.create(new AmountCode("ATL DD", "Pagrindinis atlyginimas"));
        amountCodeDAO.create(new AmountCode("ATOST", "Kasmetinės atostogos"));
        amountCodeDAO.create(new AmountCode("LIG PAS", "Ligos pašalpa"));
        amountCodeDAO.create(new AmountCode("ALGA PRD", "Priedas prie algos"));
        amountCodeDAO.create(new AmountCode("PREM REZ KETV", "Premija už ketvirčio rezultatus"));
        amountCodeDAO.create(new AmountCode("PREM REZ MET", "Premija už metų rezultatus"));
        amountCodeDAO.create(new AmountCode("DOVANA", "Dovana"));
    }

    public void createEmployees(EntityManager em) {
*/
/*        EmployeeRepository employeeRepository = new EmployeeRepository(em);
        employeeRepository.create(new Employee("Pirmas", "", "Pirmokas" ));
        employeeRepository.create(new Employee("Antras", "", "Antrokas" ));
        employeeRepository.create(new Employee("Trečias", "", "Trečiokas" ));
        employeeRepository.create(new Employee("Ketvirtas", "", "Ketvirtokas" ));
        employeeRepository.create(new Employee("Penktas", "", "Penktokas" ));
        employeeRepository.create(new Employee("Šeštas", "", "Šeštokas" ));
        employeeRepository.create(new Employee("Septintas", "", "Septintokas" ));
        employeeRepository.create(new Employee("Aštuntas", "", "Aštuntokas" ));
        employeeRepository.create(new Employee("Devintas", "", "Devintokas" ));
        employeeRepository.create(new Employee("Dešimtas", "", "Dešimtokas" ));*//*

    }

    public void createContracts(EntityManager em){
        */
/*EmployeeRepository employeeRepository = new EmployeeRepository(em);
        ContractDAO contractDAO = new ContractDAO(em);

        contractDAO.create(new Contract(employeeRepository.read(1), LocalDate.of(2021, 01, 01), LocalDate.of(2021, 01, 01), null));
        contractDAO.create(new Contract(employeeRepository.read(1), LocalDate.of(2021, 01, 01), LocalDate.of(2021, 01, 01), null));

        contractDAO.create(new Contract(employeeRepository.read(2), LocalDate.of(2021, 01, 01), LocalDate.of(2021, 01, 01), null));
        contractDAO.create(new Contract(employeeRepository.read(2), LocalDate.of(2021, 01, 01), LocalDate.of(2021, 01, 01), null));

        contractDAO.create(new Contract(employeeRepository.read(3), LocalDate.of(2021, 01, 01), LocalDate.of(2021, 01, 01), null));
        contractDAO.create(new Contract(employeeRepository.read(3), LocalDate.of(2021, 01, 01), LocalDate.of(2021, 01, 01), null));

        contractDAO.create(new Contract(employeeRepository.read(4), LocalDate.of(2021, 01, 01), LocalDate.of(2021, 01, 01), null));
        contractDAO.create(new Contract(employeeRepository.read(4), LocalDate.of(2021, 01, 01), LocalDate.of(2021, 01, 01), null));

        contractDAO.create(new Contract(employeeRepository.read(5), LocalDate.of(2021, 01, 01), LocalDate.of(2021, 01, 01), null));
        contractDAO.create(new Contract(employeeRepository.read(5), LocalDate.of(2021, 01, 01), LocalDate.of(2021, 01, 01), null));

        contractDAO.create(new Contract(employeeRepository.read(6), LocalDate.of(2021, 01, 01), LocalDate.of(2021, 01, 01), null));
        contractDAO.create(new Contract(employeeRepository.read(6), LocalDate.of(2021, 01, 01), LocalDate.of(2021, 01, 01), null));

        contractDAO.create(new Contract(employeeRepository.read(7), LocalDate.of(2021, 01, 01), LocalDate.of(2021, 01, 01), null));
        contractDAO.create(new Contract(employeeRepository.read(7), LocalDate.of(2021, 01, 01), LocalDate.of(2021, 01, 01), null));

        contractDAO.create(new Contract(employeeRepository.read(8), LocalDate.of(2021, 01, 01), LocalDate.of(2021, 01, 01), null));
        contractDAO.create(new Contract(employeeRepository.read(8), LocalDate.of(2021, 01, 01), LocalDate.of(2021, 01, 01), null));

        contractDAO.create(new Contract(employeeRepository.read(9), LocalDate.of(2021, 01, 01), LocalDate.of(2021, 01, 01), null));
        contractDAO.create(new Contract(employeeRepository.read(9), LocalDate.of(2021, 01, 01), LocalDate.of(2021, 01, 01), null));

        contractDAO.create(new Contract(employeeRepository.read(10), LocalDate.of(2021, 01, 01), LocalDate.of(2021, 01, 01), null));
        contractDAO.create(new Contract(employeeRepository.read(10), LocalDate.of(2021, 01, 01), LocalDate.of(2021, 01, 01), null));
*//*

    }

    public void createContractLines(EntityManager em){
        */
/*ContractLineDAO contractLineDAO = new ContractLineDAO(em);
        ScheduleCodeDAO scheduleCodeDAO = new ScheduleCodeDAO(em);
        PositionCodeDAO positionCodeDAO = new PositionCodeDAO(em);

        contractLineDAO.create(new ContractLine(new ContractLineID(1, LocalDate.of(2021, 01, 01)), scheduleCodeDAO.read("A5"), positionCodeDAO.read("DIR"), 1, ContractLine.AmountType.MONTHLY, 3000f));
        contractLineDAO.create(new ContractLine(new ContractLineID(2, LocalDate.of(2021, 01, 01)), scheduleCodeDAO.read("A5"), positionCodeDAO.read("DIR"), 1, ContractLine.AmountType.HOURLY, 10f));
        contractLineDAO.create(new ContractLine(new ContractLineID(3, LocalDate.of(2021, 01, 01)), scheduleCodeDAO.read("A5"), positionCodeDAO.read("PRG"), 1, ContractLine.AmountType.MONTHLY, 2000f));
        contractLineDAO.create(new ContractLine(new ContractLineID(4, LocalDate.of(2021, 01, 01)), scheduleCodeDAO.read("A5"), positionCodeDAO.read("PRG"), 1, ContractLine.AmountType.HOURLY, 4f));
        contractLineDAO.create(new ContractLine(new ContractLineID(5, LocalDate.of(2021, 01, 01)), scheduleCodeDAO.read("A5"), positionCodeDAO.read("KON"), 1, ContractLine.AmountType.MONTHLY, 600f));
        contractLineDAO.create(new ContractLine(new ContractLineID(6, LocalDate.of(2021, 01, 01)), scheduleCodeDAO.read("A5"), positionCodeDAO.read("KON"), 1, ContractLine.AmountType.HOURLY, 5f));
        contractLineDAO.create(new ContractLine(new ContractLineID(7, LocalDate.of(2021, 01, 01)), scheduleCodeDAO.read("A5"), positionCodeDAO.read("BUH"), 1, ContractLine.AmountType.MONTHLY, 1500f));
        contractLineDAO.create(new ContractLine(new ContractLineID(8, LocalDate.of(2021, 01, 01)), scheduleCodeDAO.read("A5"), positionCodeDAO.read("BUH"), 1, ContractLine.AmountType.HOURLY, 7f));
        contractLineDAO.create(new ContractLine(new ContractLineID(9, LocalDate.of(2021, 01, 01)), scheduleCodeDAO.read("A5"), positionCodeDAO.read("HR"), 1, ContractLine.AmountType.MONTHLY, 800f));
        contractLineDAO.create(new ContractLine(new ContractLineID(10, LocalDate.of(2021, 01, 01)), scheduleCodeDAO.read("A5"), positionCodeDAO.read("HR"), 1, ContractLine.AmountType.HOURLY, 6f));
        contractLineDAO.create(new ContractLine(new ContractLineID(11, LocalDate.of(2021, 01, 01)), scheduleCodeDAO.read("A5"), positionCodeDAO.read("VAD"), 1, ContractLine.AmountType.MONTHLY, 8000f));
        contractLineDAO.create(new ContractLine(new ContractLineID(12, LocalDate.of(2021, 01, 01)), scheduleCodeDAO.read("A5"), positionCodeDAO.read("VAD"), 1, ContractLine.AmountType.HOURLY, 8f));
        contractLineDAO.create(new ContractLine(new ContractLineID(13, LocalDate.of(2021, 01, 01)), scheduleCodeDAO.read("A5"), positionCodeDAO.read("VYR KON"), 1, ContractLine.AmountType.MONTHLY, 1200f));
        contractLineDAO.create(new ContractLine(new ContractLineID(14, LocalDate.of(2021, 01, 01)), scheduleCodeDAO.read("A5"), positionCodeDAO.read("VYR KON"), 1, ContractLine.AmountType.HOURLY, 9f));
        contractLineDAO.create(new ContractLine(new ContractLineID(15, LocalDate.of(2021, 01, 01)), scheduleCodeDAO.read("A5"), positionCodeDAO.read("INZ"), 1, ContractLine.AmountType.MONTHLY, 900f));
        contractLineDAO.create(new ContractLine(new ContractLineID(16, LocalDate.of(2021, 01, 01)), scheduleCodeDAO.read("A5"), positionCodeDAO.read("INZ"), 1, ContractLine.AmountType.HOURLY, 4f));
        contractLineDAO.create(new ContractLine(new ContractLineID(17, LocalDate.of(2021, 01, 01)), scheduleCodeDAO.read("A5"), positionCodeDAO.read("VADYB"), 1, ContractLine.AmountType.MONTHLY, 600f));
        contractLineDAO.create(new ContractLine(new ContractLineID(18, LocalDate.of(2021, 01, 01)), scheduleCodeDAO.read("A5"), positionCodeDAO.read("VADYB"), 1, ContractLine.AmountType.HOURLY, 5f));
        contractLineDAO.create(new ContractLine(new ContractLineID(19, LocalDate.of(2021, 01, 01)), scheduleCodeDAO.read("A5"), positionCodeDAO.read("PRG"), 1, ContractLine.AmountType.MONTHLY, 700f));
        contractLineDAO.create(new ContractLine(new ContractLineID(20, LocalDate.of(2021, 01, 01)), scheduleCodeDAO.read("A5"), positionCodeDAO.read("PRG"), 1, ContractLine.AmountType.HOURLY, 6f));
  *//*
  }
}
*/
