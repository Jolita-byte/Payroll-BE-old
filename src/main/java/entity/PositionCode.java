package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "position_code")
public class PositionCode {
    @Id
    private String id;
    private String description;

    @OneToMany(mappedBy="position_code")
    private List<ContractLine> contractLines;

    public PositionCode() {
    }

    public PositionCode(String id, String description) {
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

    @Override
    public String toString() {
        return "PositionCode{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                //", contractLines=" + contractLines +
                '}';
    }
}
