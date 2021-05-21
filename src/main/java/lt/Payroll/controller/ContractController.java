package lt.Payroll.controller;

import lt.Payroll.model.Contract;
import lt.Payroll.model.dto.ContractDTO;
import lt.Payroll.model.ContractLine;
import lt.Payroll.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContractController {
    @Autowired
    private ContractService contractService;

    @GetMapping(value = "/contracts")
    public List<Contract> getAllContracts(){
        return contractService.getAllContracts();
    }

    @GetMapping(value = "/contracts/lines")
    public List<ContractLine> getAllContractLines(){
        return contractService.getAllContractLines();
    }

    @GetMapping(value = "/contract/{id}")
    public Contract getContractById(@PathVariable Long id){
        return contractService.getContractById(id);
    }

    @GetMapping(value = "/contract/{id}/lines")
    public List<ContractLine> getContractLinesByContractId(@PathVariable Long id){
        return contractService.getContractLinesByContractId(id);
    }

    @PostMapping(value = "/contract")
    public Contract postContract(@RequestBody ContractDTO contractDTO){
        return contractService.postContract(contractDTO);
    }
}
