//import static Calculations.Average.calculateAverage;

import Amounts.AmountCode;

import java.lang.reflect.Type;

public class Main {
    public static void main(String[] args) {
        AmountCode ATL_DD = new AmountCode("ATL DD", AmountCode.Type.EARNING);
        AmountCode ATL_DD2 = new AmountCode("ATL DD", AmountCode.Type.EARNING);
        System.out.println(ATL_DD.equals(ATL_DD2));
        AmountCode.Type a = AmountCode.Type.EARNING;
        AmountCode.Type b = AmountCode.Type.EARNING;
        System.out.println(a.equals(b));
    }
}
