package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "time_code")
public class TimeCode {
    @Id
    private String id;

    private String description;

    @OneToMany(mappedBy="timeCode")
    private List<EmployeeTimesheetEntry> employeeTimeTableEntries;

    public TimeCode() {
    }

    public TimeCode(String id, String description) {
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
        return "TimeCode{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
