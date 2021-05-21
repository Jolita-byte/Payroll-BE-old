package lt.Payroll.service;

import lt.Payroll.model.AmountCode;
import lt.Payroll.repository.AmountCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmountCodeService {
    @Autowired
    private AmountCodeRepository amountCodeRepository;


    public List<AmountCode> getAllAmountCodes() {
        return amountCodeRepository.findAll();
    }
}
