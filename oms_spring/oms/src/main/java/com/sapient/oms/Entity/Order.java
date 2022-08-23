package com.sapient.oms.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sapient.oms.Enums.OrderStatus;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private OrderStatus orderstatus;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Location deliveraddress;
    private float price;

    public Order(int id, OrderStatus orderstatus, Location deliveraddress) {
        this.id = id;
        this.orderstatus = orderstatus;
        this.deliveraddress = deliveraddress;
    }
    public Order(int id, OrderStatus orderstatus) {
        this.id = id;
        this.orderstatus = orderstatus;
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

    public OrderStatus getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(OrderStatus orderstatus) {
        this.orderstatus = orderstatus;
    }

    public Location getDeliveraddress() {
        return deliveraddress;
    }

    public void setDeliveraddress(Location deliveraddress) {
        this.deliveraddress = deliveraddress;
    }

}
