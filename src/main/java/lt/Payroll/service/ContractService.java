package lt.Payroll.service;

import lt.Payroll.model.Contract;
import lt.Payroll.model.dto.ContractDTO;
import lt.Payroll.model.ContractLine;
import lt.Payroll.model.Employee;
import lt.Payroll.repository.ContractLineRepository;
import lt.Payroll.repository.ContractRepository;
import lt.Payroll.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private ContractLineRepository contractLineRepository;


    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    public List<ContractLine> getAllContractLines() {
        return contractLineRepository.findAll();
    }

    public Contract postContract(ContractDTO contractDTO) {
        Contract contract = new Contract();
        Long employee_id = contractDTO.getEmployee_id();
        Optional<Employee> employeeOptional = employeeRepository.findById(employee_id);
        Employee employee = employeeOptional.orElseThrow(() -> new RuntimeException("Employee was not found"));
        contract.setEmployee(employee);
        contract.setEmployment_date(contractDTO.getEmployment_date());
        contract.setContract_sign_date(contractDTO.getContract_sign_date());
        contract.setTermination_date(contractDTO.getTermination_date());
        contractRepository.save(contract);
        return contract;
    }

    public Contract getContractById(Long id) {
        return contractRepository.findById(id).orElseThrow(() -> new RuntimeException("Contract was not found"));
    }

    public List<ContractLine> getContractLinesByContractId(Long id) {
        return contractLineRepository.findAllByContractId(id);
    }
}
