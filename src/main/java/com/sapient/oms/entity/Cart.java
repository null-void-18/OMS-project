package com.sapient.oms.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;

    private int storeId;

    @OneToMany
    private List<CartItem> cartItems;

    public Cart() {
    }

    public Cart(Customer customer, int storeId, List<CartItem> cartItems) {
        this.customer = customer;
        this.storeId = storeId;
        this.cartItems = cartItems;
    }

    public Cart(int id, Customer customer, int storeId, List<CartItem> cartItems) {
        this(customer, storeId, cartItems);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[ CartId:- " + this.id);
        builder.append("Customer:- " + this.customer);
        builder.append(" StoreId:- " + this.storeId);
        builder.append("CartItems:- " + this.cartItems.size() + " ]");
        return builder.toString();
    }
}
