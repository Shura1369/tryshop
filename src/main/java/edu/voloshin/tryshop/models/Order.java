package edu.voloshin.tryshop.models;

import java.time.LocalDate;
import java.util.Objects;

public class Order {
    private String id;
    private boolean isActive;
    private  Product product;
    private LocalDate getDate;
    private LocalDate retDate;
    private double issuedMoney;//выдано денег
    private double sellingPrice;//цена продажи
    private double buybackPrice;//выкупная цена
    private Person person;

    public Order() {
    }

    public Order(String id, boolean isActive, Product product, LocalDate getDate, LocalDate retDate,
                 double issuedMoney, double sellingPrice, double buybackPrice, Person person) {
        this.id = id;
        this.isActive = isActive;
        this.product = product;
        this.getDate = getDate;
        this.retDate = retDate;
        this.issuedMoney = issuedMoney;
        this.sellingPrice = sellingPrice;
        this.buybackPrice = buybackPrice;
        this.person = person;
    }

    public Order(boolean isActive, Product product, LocalDate getDate, LocalDate retDate,
                 double issuedMoney, double sellingPrice, double buybackPrice, Person person) {
        this.isActive = isActive;
        this.product = product;
        this.getDate = getDate;
        this.retDate = retDate;
        this.issuedMoney = issuedMoney;
        this.sellingPrice = sellingPrice;
        this.buybackPrice = buybackPrice;
        this.person = person;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDate getGetDate() {
        return getDate;
    }

    public void setGetDate(LocalDate getDate) {
        this.getDate = getDate;
    }

    public LocalDate getRetDate() {
        return retDate;
    }

    public void setRetDate(LocalDate retDate) {
        this.retDate = retDate;
    }

    public double getIssuedMoney() {
        return issuedMoney;
    }

    public void setIssuedMoney(double issuedMoney) {
        this.issuedMoney = issuedMoney;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getBuybackPrice() {
        return buybackPrice;
    }

    public void setBuybackPrice(double buybackPrice) {
        this.buybackPrice = buybackPrice;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id.equals(order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
