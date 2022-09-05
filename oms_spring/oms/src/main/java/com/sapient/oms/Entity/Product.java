package com.sapient.oms.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @NotBlank(message = "please provide product name here")
    private String productName;

    @JsonFormat(pattern = "dd/mm/yyyy")
    private Date mdate;

    @JsonFormat(pattern = "dd/mm/yyyy")
    private Date edate;
    private int cost;
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private Collection<Inventory> inventory = new ArrayList<Inventory>();

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private Collection<OrderItem> orderitems = new ArrayList<OrderItem>();

    public Product(int productId, String productName, Date mdate, Date edate, int cost,Collection<Inventory> inventories) {
        this.productId = productId;
        this.productName = productName;
        this.mdate = mdate;
        this.edate = edate;
        this.cost = cost;
        this.inventory = inventories;
    }

    public Product() {
    }
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setInventory(Collection<Inventory> inventory) {
        this.inventory = inventory;
    }

    public Collection<OrderItem> getOrderitems() {
        return orderitems;
    }

    public void setOrderitems(Collection<OrderItem> orderitems) {
        this.orderitems = orderitems;
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

    public void setCost(int d) {
        this.cost = d;
    }

    
    @Override
    public int hashCode() {
        return this.productId;
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
        if (this.productId != product.productId)
            return false;
        return true;
    }

    @Override
    public String toString() {

        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("[ Product Id:- " + this.productId);
        strBuilder.append(", Title:- " + this.productName);
        strBuilder.append(", Price:-  " + this.cost);
        strBuilder.append(", Manufactured:- " + this.mdate);
        strBuilder.append(", Expiry:- " + this.edate + " ]");

        return strBuilder.toString();
    }

    public Collection<Inventory> getInventory() {
        return inventory;
    }
}