package entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "employee_schedule_entry")
public class EmployeeScheduleEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="contract_id", nullable=false)
    private Contract contract;

    @ManyToOne
    @JoinColumn(name="shift_code_id", nullable=false)
    private ShiftCode shift_code;

    @ManyToOne
    @JoinColumn(name="time_code_id", nullable=false)
    private TimeCode time_code;

    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    public EmployeeScheduleEntry() {
    }

    public EmployeeScheduleEntry(Contract contract, ShiftCode shift_code, TimeCode time_code, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this.contract = contract;
        this.shift_code = shift_code;
        this.time_code = time_code;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public ShiftCode getShift_code() {
        return shift_code;
    }

    public void setShift_code(ShiftCode shift_code) {
        this.shift_code = shift_code;
    }

    public TimeCode getTime_code() {
        return time_code;
    }

    public void setTime_code(TimeCode time_code) {
        this.time_code = time_code;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    @Override
    public String toString() {
        return "EmployeeScheduleEntry{" +
                "id=" + id +
                ", contract=" + contract +
                ", shift_code=" + shift_code +
                ", time_code=" + time_code +
                ", startDateTime=" + startDateTime +
                ", endDateTime=" + endDateTime +
                '}';
    }
}
