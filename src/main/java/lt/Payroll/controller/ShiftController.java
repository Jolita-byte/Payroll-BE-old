package lt.Payroll.controller;

import lt.Payroll.model.Shift;
import lt.Payroll.model.ShiftLine;
import lt.Payroll.service.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/shifts")
public class ShiftController {
    @Autowired
    private ShiftService shiftService;

    @GetMapping
    public List<Shift> getAllShifts(){
        return shiftService.getAllShifts();
    }

    @GetMapping (value = "/lines")
    public List<ShiftLine> getAllShiftLines(){
        return shiftService.getAllShiftLines();
    }
}
