package br.com.cvc.entities;

import java.math.BigDecimal;

public class Room {

    private int roomID;
    private String categoryName;
    private BigDecimal totalPrice;
    private Price price;

    public Room(int roomID, String categoryName, BigDecimal totalPrice, Price price) {
        this.roomID = roomID;
        this.categoryName = categoryName;
        this.totalPrice = totalPrice;
        this.price = price;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}
