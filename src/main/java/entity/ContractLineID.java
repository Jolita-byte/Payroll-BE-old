package entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class ContractLineID implements Serializable {
    private Integer contractID;
    private LocalDate startDate;

    public ContractLineID() {
    }

    public ContractLineID(Integer contractID, LocalDate startDate) {
        this.contractID = contractID;
        this.startDate = startDate;
    }

    public Integer getContractID() {
        return contractID;
    }

    public void setContractID(Integer contractID) {
        this.contractID = contractID;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "ContractLineID{" +
                "contractID=" + contractID +
                ", startDate=" + startDate +
                '}';
    }
}
