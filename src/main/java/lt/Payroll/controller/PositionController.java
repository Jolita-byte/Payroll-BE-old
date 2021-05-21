package lt.Payroll.controller;

import lt.Payroll.model.Position;
import lt.Payroll.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/positions")
public class PositionController {
    @Autowired
    private PositionService positionService;

    @GetMapping
    public List<Position> getAllPositions(){
        return positionService.getAllPositions();
    }
}
