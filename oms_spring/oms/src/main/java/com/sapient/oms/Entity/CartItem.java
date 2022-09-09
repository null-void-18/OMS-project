package com.sapient.oms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int inventory;
    private int quantity;

    @OneToOne
    private Product product;

    public CartItem() {
    }

    public CartItem(int inventory, int quantity, Product product) {
        this.inventory = inventory;
        this.quantity = quantity;
        this.product = product;
    }

    public CartItem(int id, int inventory, int quantity, Product product) {
        this(inventory, quantity, product);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[CartItemId:- " + this.id);
        builder.append(", Product Id:- " + this.product.getProductId());
        builder.append(", Inventory:- " + this.inventory);
        builder.append(", Quantity:- " + this.quantity);
        return builder.toString();
    }
}
