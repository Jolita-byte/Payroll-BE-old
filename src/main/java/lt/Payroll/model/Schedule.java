package lt.Payroll.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
//@Table(name = "schedule_code")
public class Schedule {
    @Id
    private String id;
    private String description;

    //@OneToMany(mappedBy="schedule_code") //laikinai
    //private List<ContractLine> contractLines; //laiinai

    @OneToMany(mappedBy="schedule")
    private List<SchedulePatternLine> schedulePatternLines;
}
