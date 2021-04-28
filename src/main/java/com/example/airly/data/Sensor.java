package com.example.airly.data;

public class Sensor {

    private long id;
    private String address;
    private String owner;

    public Sensor(long id, String address, String owner) {
        this.id = id;
        this.address = address;
        this.owner = owner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
