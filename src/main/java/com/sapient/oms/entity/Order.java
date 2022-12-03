package com.sapient.oms.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sapient.oms.enums.ORDER_STATUS;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    private int orderId;
    @Column(name = "cost")
    private float price;
    @Enumerated(EnumType.STRING)
    ORDER_STATUS orderStatus;
    @JsonFormat(pattern = "dd/mm/yyyy")
    Date orderDate;
    

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private Collection<OrderItem> orderitems = new ArrayList<OrderItem>();

    public Order() {
    }

    public Order(int orderId, float price, ORDER_STATUS placed,Date date) {
        this.orderId = orderId;
        this.price = price;
        this.orderStatus = placed;
        this.orderDate = date;
    }

    public Order(Order order){
        this.orderId = order.orderId;
        this.price = order.price;
        this.orderStatus = order.orderStatus;
        this.orderDate = order.orderDate;
    }
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Collection<OrderItem> getOrderitems() {
        return orderitems;
    }

    public void setOrderitems(Collection<OrderItem> orderitems) {
        this.orderitems = orderitems;
    }

    public ORDER_STATUS getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(ORDER_STATUS orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public int hashCode() {
        return this.orderId;
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
        if (this.orderId != order.orderId)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", orderStatus=" + orderStatus + ", orderitems=" + orderitems + ", price="
                + price + "]";
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
