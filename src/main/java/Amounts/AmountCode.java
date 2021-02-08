package Amounts;

public class AmountCode {
    public enum Type{
        EARNING,
        DEDUCTION,
        INCOME_IN_KIND,
        BONUS_QUARTERLY,
        BONUS_ANNUAL;
    }
    private String code;
    private Type type;

    public AmountCode(String code, Type type) {
        this.code = code;
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public Type getType() {
        return type;
    }
}
