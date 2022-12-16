package com.spring.ecommerce.model;

import java.util.Date;

public class Order {
    private Integer id;
    private String number;
    private Date creationDate;
    private Date crecivedDate;
    private double total;

    public Order() {
    }

    public Order(Integer id, String number, Date creationDate, Date crecivedDate, double total) {
        this.id = id;
        this.number = number;
        this.creationDate = creationDate;
        this.crecivedDate = crecivedDate;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getCrecivedDate() {
        return crecivedDate;
    }

    public void setCrecivedDate(Date crecivedDate) {
        this.crecivedDate = crecivedDate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", creationDate=" + creationDate +
                ", crecivedDate=" + crecivedDate +
                ", total=" + total +
                '}';
    }
}
