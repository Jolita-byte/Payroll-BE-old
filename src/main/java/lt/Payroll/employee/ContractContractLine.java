package lt.Payroll.employee;

public class ContractContractLine {
    private Contract contract;
    private ContractLine contractLine;

    public ContractContractLine(Contract contract, ContractLine contractLine) {
        this.contract = contract;
        this.contractLine = contractLine;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public ContractLine getContractLine() {
        return contractLine;
    }

    public void setContractLine(ContractLine contractLine) {
        this.contractLine = contractLine;
    }

    @Override
    public String toString() {
        return "\nContractContractLine{" +
                "contract=" + contract +
                ", contractLine=" + contractLine +
                "}";
    }
}
