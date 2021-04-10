package entity;

import javax.persistence.*;

@Entity
@Table(name = "shift_code")
public class ShiftCode {
    @Id
    private String id;
    private String description;

    public ShiftCode() {
    }

    public ShiftCode(String id, String description) {
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
        return "ShiftCode{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
