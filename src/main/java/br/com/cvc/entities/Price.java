package br.com.cvc.entities;

import java.math.BigDecimal;

public class Price {

    private BigDecimal pricePerDayAdult;
    private BigDecimal pricePerDayChild;

    public Price(BigDecimal pricePerDayAdult, BigDecimal pricePerDayChild) {
        this.pricePerDayAdult = pricePerDayAdult;
        this.pricePerDayChild = pricePerDayChild;
    }

    public BigDecimal getPricePerDayAdult() {
        return pricePerDayAdult;
    }

    public void setPricePerDayAdult(BigDecimal pricePerDayAdult) {
        this.pricePerDayAdult = pricePerDayAdult;
    }

    public BigDecimal getPricePerDayChild() {
        return pricePerDayChild;
    }

    public void setPricePerDayChild(BigDecimal pricePerDayChild) {
        this.pricePerDayChild = pricePerDayChild;
    }
}
