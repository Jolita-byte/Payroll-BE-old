package lt.Payroll.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "amount_code")
public class AmountCode {
    @Id
    private String id;
    private String description;

    @OneToMany(mappedBy="id.amountCode")
    private List<EmployeeAmount> employeeAmounts;



    //    public enum Type{
//        EARNING,
//        DEDUCTION,
//        INCOME_IN_KIND,
//        BONUS_QUARTERLY,
//        BONUS_ANNUAL;
//    }
//    private String code;
//    private Type type;
}
