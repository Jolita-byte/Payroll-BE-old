package lt.Payroll.service;

import lt.Payroll.model.ActivityCode;
import lt.Payroll.repository.ActivityCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityCodeService {
    @Autowired
    private ActivityCodeRepository activityCodeRepository;


    public List<ActivityCode> getAllActivityCodes() {
        return activityCodeRepository.findAll();
    }
}
