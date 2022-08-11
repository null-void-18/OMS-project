package com.sapient.oms.entity;

import java.util.Date;

public class Product {
    private int id;
    private String productName;
    private Date mdate;
    private Date edate;
    private double cost;

    public Product(int id, String productName, Date mdate, Date edate, Double cost) {
        this.id = id;
        this.productName = productName;
        this.mdate = mdate;
        this.edate = edate;
        this.cost = cost;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public Date getMdate() {
        return mdate;
    }
    public void setMdate(Date mdate) {
        this.mdate = mdate;
    }
    public Date getEdate() {
        return edate;
    }
    public void setEdate(Date edate) {
        this.edate = edate;
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double d) {
        this.cost = d;
    }

    @Override
    public String toString() {

        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("[ Product Id:- " + this.id);
        strBuilder.append(", Title:- " + this.productName);
        strBuilder.append(", Price:-  " + this.cost);
        strBuilder.append(", Manufactured:- " + this.mdate);
        strBuilder.append(", Expiry:- " + this.edate + " ]");
    
        return strBuilder.toString();
    }
}
