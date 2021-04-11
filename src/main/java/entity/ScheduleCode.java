package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "schedule_code")
public class ScheduleCode {
    @Id
    private String id;
    private String description;

    @OneToMany(mappedBy="scheduleCode")
    private List<ContractLine> contractLines;

    public ScheduleCode() {
    }

    public ScheduleCode(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ContractLine> getContractLines() {
        return contractLines;
    }

    public void setContractLines(List<ContractLine> contractLines) {
        this.contractLines = contractLines;
    }


}
