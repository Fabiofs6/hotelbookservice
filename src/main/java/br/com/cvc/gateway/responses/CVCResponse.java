package br.com.cvc.gateway.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CVCResponse {

    private int id;
    private String name;
    private int cityCode;
    private String cityName;
    @JsonProperty("rooms")
    private List<CVCResponseRoom> roomsList;

    public CVCResponse() {
    }

    public CVCResponse(int id, String name, int cityCode, String cityName, List<CVCResponseRoom> roomsList) {
        this.id = id;
        this.name = name;
        this.cityCode = cityCode;
        this.cityName = cityName;
        this.roomsList = roomsList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCityCode() {
        return cityCode;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<CVCResponseRoom> getRoomsList() {
        return roomsList;
    }

    public void setRoomsList(List<CVCResponseRoom> roomsList) {
        this.roomsList = roomsList;
    }
}
