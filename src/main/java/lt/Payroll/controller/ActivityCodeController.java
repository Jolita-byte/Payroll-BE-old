package lt.Payroll.controller;

import lt.Payroll.model.ActivityCode;
import lt.Payroll.service.ActivityCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/activityCodes")
public class ActivityCodeController {
    @Autowired
    private ActivityCodeService activityCodeService;

    @GetMapping
    public List<ActivityCode> getAllActivityCodes(){
        return activityCodeService.getAllActivityCodes();
    }

}
