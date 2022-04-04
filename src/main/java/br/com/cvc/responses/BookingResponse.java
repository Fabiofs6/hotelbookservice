package br.com.cvc.responses;

import br.com.cvc.entities.Room;

import java.util.List;

public class BookingResponse {

    private int id;
    private String cityName;
    private List<Room> rooms;

    public BookingResponse(int id, String cityName, List<Room> rooms) {
        this.id = id;
        this.cityName = cityName;
        this.rooms = rooms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
