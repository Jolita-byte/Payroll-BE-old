package lt.Payroll.service;

import lt.Payroll.model.Shift;
import lt.Payroll.model.ShiftLine;
import lt.Payroll.repository.ShiftLineRepository;
import lt.Payroll.repository.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiftService {
    @Autowired
    private ShiftRepository shiftRepository;
    @Autowired
    private ShiftLineRepository shiftLineRepository;


    public List<Shift> getAllShifts() {
        return shiftRepository.findAll();
    }

    public List<ShiftLine> getAllShiftLines() {
        return shiftLineRepository.findAll();
    }
}
