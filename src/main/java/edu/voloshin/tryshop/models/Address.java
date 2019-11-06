package edu.voloshin.tryshop.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Address {
    @Id
    private String id;
    private String country;
    private String area;
    private String city;
    private String street;
    private String building;
    private String house;

    public Address() {

    }

    public Address(String id, String country, String area, String city, String street, String building, String house) {
        this.id = id;
        this.country = country;
        this.area = area;
        this.city = city;
        this.street = street;
        this.building = building;
        this.house = house;
    }

    public Address(String country, String area, String city, String street, String building, String house) {
        this.country = country;
        this.area = area;
        this.city = city;
        this.street = street;
        this.building = building;
        this.house = house;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    @Override
    public String toString() {
        if(this.id==null) return  "planet Earth";
        else {
            return "Address{" +
                    "id='" + id + '\'' +
                    ", country='" + country + '\'' +
                    ", area='" + area + '\'' +
                    ", city='" + city + '\'' +
                    ", street='" + street + '\'' +
                    ", building='" + building + '\'' +
                    ", house='" + house + '\'' +
                    '}';
        }
    }
}
