package br.com.cvc.gateway.responses;

import java.math.BigDecimal;

public class CVCPriceResponse {

    private BigDecimal adult;
    private BigDecimal child;

    public CVCPriceResponse() {}

    public CVCPriceResponse(BigDecimal adult, BigDecimal child) {
        this.adult = adult;
        this.child = child;
    }

    public BigDecimal getAdult() {
        return adult;
    }

    public void setAdult(BigDecimal adult) {
        this.adult = adult;
    }

    public BigDecimal getChild() {
        return child;
    }

    public void setChild(BigDecimal child) {
        this.child = child;
    }
}
