package com.sapient.oms.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank(message = "please provide product name here")
    private String productName;

    @JsonFormat(pattern = "dd/mm/yyyy")
    private Date mdate;

    @JsonFormat(pattern = "dd/mm/yyyy")
    private Date edate;
    private double cost;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id.product")
    private Set<Inventory> inventory = new HashSet<Inventory>();


    public Product(int id, String productName, Date mdate, Date edate, double cost,Set<Inventory> inventories) {
        this.id = id;
        this.productName = productName;
        this.mdate = mdate;
        this.edate = edate;
        this.cost = cost;
        this.inventory = inventories;
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
    public int hashCode() {
        return this.id;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product product = (Product) obj;
        if (this.id != product.id)
            return false;
        return true;
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

    public Set<Inventory> getInventory() {
        return inventory;
    }

    public void setInventory(Set<Inventory> inventory) {
        this.inventory = inventory;
    }
}