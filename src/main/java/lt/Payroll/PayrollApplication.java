package lt.Payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PayrollApplication {
    //private static final String URL = "jdbc:mysql://localhost:3306/payroll";
    //private static final String USER = "root";
    //private static final String PASSWORD = "Jolita4*";
    public static void main(String[] args){
        SpringApplication.run(PayrollApplication.class, args);
    }
}
