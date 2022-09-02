package com.sapient.oms.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sapient.oms.enums.ORDER_STATUS;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    private int id;
    @Column(name = "cost")
    private float price;
    @Enumerated(EnumType.STRING)
    ORDER_STATUS orderStatus;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "id.order")
    private Set<OrderItem> orderitems = new HashSet<OrderItem>();

    public Order() {
    }

    public Order(int id, float price, ORDER_STATUS placed) {
        this.id = id;
        this.price = price;
        this.orderStatus = placed;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ORDER_STATUS getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(ORDER_STATUS orderStatus) {
        this.orderStatus = orderStatus;
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
        Order order = (Order) obj;
        if (this.id != order.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", price=" + price + "]";
    }
}
