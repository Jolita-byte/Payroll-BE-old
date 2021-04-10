package entity;

import javax.persistence.*;

@Entity
@Table(name = "schedule_code")
public class ScheduleCode {
    @Id
    private String id;
    private String description;

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

    @Override
    public String toString() {
        return "ScheduleCode{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
