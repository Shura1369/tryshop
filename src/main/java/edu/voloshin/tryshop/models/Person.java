package edu.voloshin.tryshop.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Person {

    @Id
    private String id;
    private Passport passport;
    private Gender gender;
    private Address address;
    private String ipn;

    public Person() {
    }

    public Person(Passport passport) {
        this.passport = passport;
        gender = Gender.ANDROGYNE;

    }

    public Person(Passport passport, Gender gender, Address address, String ipn) {
        this.passport = passport;
        this.gender = gender;
        this.address = address;
        this.ipn = ipn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getIpn() {
        return ipn;
    }

    public void setIpn(String ipn) {
        this.ipn = ipn;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", passport=" + passport +
                ", gender=" + gender +
                ", address=" + address +
                ", ipn=" + ipn +
                '}';
    }
}
