package lt.Payroll.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
//@Table(name = "position")
public class Position {
    @Id
    private String id;
    private String description;

    //@OneToMany(mappedBy="position")//laikinai
    //private List<ContractLine> contractLines;//laikinai
}
