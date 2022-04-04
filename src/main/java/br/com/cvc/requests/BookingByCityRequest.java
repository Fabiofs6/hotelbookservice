package br.com.cvc.requests;

import java.time.LocalDate;

public class BookingByCityRequest {

    private int cityCode;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private int adultQuantity;
    private int childQuantity;

    public BookingByCityRequest(int cityCode, LocalDate checkIn, LocalDate checkOut, int adultQuantity, int childQuantity) {
        this.cityCode = cityCode;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.adultQuantity = adultQuantity;
        this.childQuantity = childQuantity;
    }

    public int getCityCode() {
        return cityCode;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public int getAdultQuantity() {
        return adultQuantity;
    }

    public void setAdultQuantity(int adultQuantity) {
        this.adultQuantity = adultQuantity;
    }

    public int getChildQuantity() {
        return childQuantity;
    }

    public void setChildQuantity(int childQuantity) {
        this.childQuantity = childQuantity;
    }
}
