package schedule;

import employee.ContractDAO;
import employee.ContractDAOImpl;

import java.time.LocalDate;
import java.util.List;


public class ScheduleFunctions {
    public List<EmployeeScheduleLine> fillSchedule(Integer employeeID, LocalDate begin, LocalDate end){
        //ContractDAO contractDAO = new ContractDAOImpl();
        List<EmployeeScheduleLine> employeeScheduleLines = null;
        for (LocalDate i = begin; i.isBefore(end)||i.isEqual(end); i.plusDays(1)) {


        }


        return null;
    }
}
