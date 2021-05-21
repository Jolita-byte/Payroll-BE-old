package lt.Payroll.controller;

import lt.Payroll.model.AmountCode;
import lt.Payroll.service.AmountCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/amountCodes")
public class AmountCodeController {
    @Autowired
    private AmountCodeService amountCodeService;

    @GetMapping
    public List<AmountCode> getAllAmountCodes(){
        return amountCodeService.getAllAmountCodes();
    }
}
