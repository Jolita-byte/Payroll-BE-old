package Amounts;

import Amounts.AmountCode;

import java.time.LocalDate;

public class Amount {
    private LocalDate calculationDate;
    private AmountCode amountCode;
    private float amount;

    public Amount(LocalDate calculationDate, AmountCode amountCode, float amount) {
        this.calculationDate = calculationDate;
        this.amountCode = amountCode;
        this.amount = amount;
    }

    public LocalDate getCalculationDate() {
        return calculationDate;
    }

    public AmountCode getAmountCode() {
        return amountCode;
    }

    public float getAmount() {
        return amount;
    }
}
