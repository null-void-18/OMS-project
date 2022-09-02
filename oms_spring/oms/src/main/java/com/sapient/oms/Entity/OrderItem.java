package com.sapient.oms.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "orderitems")
@AssociationOverrides({
    @AssociationOverride(name = "id.product", 
        joinColumns = @JoinColumn(name = "product_id")),
    @AssociationOverride(name = "id.order", 
        joinColumns = @JoinColumn(name = "order_id")) })
public class OrderItem {
    @EmbeddedId
    private OrderItemId id = new OrderItemId();
    private int quantity;
    private int price;

    public OrderItem() {
    }

    public OrderItem(OrderItemId id, int quantity, int price) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderItemId getId() {
        return id;
    }
    public void setId(OrderItemId id) {
        this.id = id;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    @Transient
    public Order getOrder() {
        return getId().getOrder();
    }

    @Transient
    public Product getProduct() {
        return getId().getProduct();
    }
    @Override
    public String toString() {
        return "OrderItems [id=" + id + ", price=" + price + ", quantity=" + quantity + "]";
    } 
}
