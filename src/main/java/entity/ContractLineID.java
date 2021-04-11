package entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class ContractLineID implements Serializable {
    private Integer contract_id;
    private LocalDate start_date;

    public ContractLineID() {
    }

    public ContractLineID(Integer contract_id, LocalDate start_date) {
        this.contract_id = contract_id;
        this.start_date = start_date;
    }

    public Integer getContract_id() {
        return contract_id;
    }

    public void setContract_id(Integer contract_id) {
        this.contract_id = contract_id;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    @Override
    public String toString() {
        return "ContractLineID{" +
                "contract_id=" + contract_id +
                ", start_date=" + start_date +
                '}';
    }
}
