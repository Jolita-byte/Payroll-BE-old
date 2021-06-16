package lt.Payroll.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
@Data
public class ContractLineID implements Serializable {

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="contract_id", nullable=false)
    private Contract contract;

    private LocalDate start_date;
}
