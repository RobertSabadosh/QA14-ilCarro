package com.ilCarro.qa14.models;

public class Car {
    private String country;
    private String address;
    private String distance;

    public Car setCountry(String country) {
        this.country = country;
        return this;
    }

    public Car setAddress(String address) {
        this.address = address;
        return this;
    }

    public Car setDistance(String distance) {
        this.distance = distance;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public String getAddress() {
        return address;
    }

    public String getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "Car{" +
                "country='" + country + '\'' +
                ", address='" + address + '\'' +
                ", distance='" + distance + '\'' +
                '}';
    }
}
