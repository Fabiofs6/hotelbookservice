package br.com.cvc.gateway.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CVCResponseRoom {

    private int roomID;
    private String categoryName;
    @JsonProperty("price")
    private CVCPriceResponse CVCPriceResponse;

    public CVCResponseRoom() {
    }

    public CVCResponseRoom(int roomID, String categoryName, CVCPriceResponse CVCPriceResponse) {
        this.roomID = roomID;
        this.categoryName = categoryName;
        this.CVCPriceResponse = CVCPriceResponse;
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

    public CVCPriceResponse getPrice() {
        return CVCPriceResponse;
    }

    public void setPrice(CVCPriceResponse CVCPriceResponse) {
        this.CVCPriceResponse = CVCPriceResponse;
    }
}
