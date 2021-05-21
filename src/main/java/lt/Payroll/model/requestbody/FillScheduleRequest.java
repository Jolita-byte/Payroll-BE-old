package lt.Payroll.model.requestbody;

import lombok.Data;
import lt.Payroll.model.Contract;

import java.time.LocalDate;
import java.util.List;

@Data
public class FillScheduleRequest {
    private LocalDate from;
    private LocalDate to;
    private List<Long> contract_id_list;
}
