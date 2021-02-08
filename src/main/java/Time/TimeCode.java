package Time;

public class TimeCode {
    private String code;
    private boolean actual;

    public TimeCode(String code, boolean actual) {
        this.code = code;
        this.actual = actual;
    }

    public String getCode() {
        return code;
    }

    public boolean isActual() {
        return actual;
    }
}
