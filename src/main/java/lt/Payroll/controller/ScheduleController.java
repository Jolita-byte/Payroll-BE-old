package lt.Payroll.controller;

import lt.Payroll.model.EmployeeScheduleEntry;
import lt.Payroll.model.Schedule;
import lt.Payroll.model.SchedulePatternLine;
import lt.Payroll.model.requestbody.FillScheduleRequest;
import lt.Payroll.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/schedules")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping
    public List<Schedule> getAllSchedules(){
        return scheduleService.getAllSchedules();
    }

    @GetMapping(value = "/patternLines")
    public List<SchedulePatternLine> getAllPatternLines(){
        return scheduleService.getAllPatternLines();
    }

    @PostMapping(value = "/fill")
    public List<EmployeeScheduleEntry> fillSchedule(@RequestBody FillScheduleRequest fillScheduleRequest){
        return scheduleService.fillSchedule(fillScheduleRequest);
    }


}
