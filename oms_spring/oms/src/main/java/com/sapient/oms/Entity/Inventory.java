package com.sapient.oms.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "product_id")
    private Product product;
 
    public Inventory() { 
    }

    public Inventory(Store store, Product product, int quantity) {
        this.store = store;
        this.product = product;
        this.quantity = quantity;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private int quantity;

    

    @Override
    public String toString() {
        return "Inventory [product=" + product + ", quantity=" + quantity + ", store=" + store + "]";
    }
}
