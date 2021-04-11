package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "amount_code")
public class AmountCode {
    @Id
    private String id;
    private String description;

    @OneToMany(mappedBy="id.amountCode")
    private List<EmployeeAmount> employeeAmounts;

    public AmountCode() {
    }

    public AmountCode(String id, String description) {
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

    @Override
    public String toString() {
        return "AmountCode{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
