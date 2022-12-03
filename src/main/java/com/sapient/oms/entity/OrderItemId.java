package com.sapient.oms.entity;

import javax.persistence.Embeddable;

@Embeddable
public class OrderItemId implements java.io.Serializable{
    private int productId;
    private int orderId;
    public OrderItemId() {
    }
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + orderId;
        result = prime * result + productId;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OrderItemId other = (OrderItemId) obj;
        if (orderId != other.orderId)
            return false;
        if (productId != other.productId)
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "OrderItemId [orderId=" + orderId + ", productId=" + productId + "]";
    }
}
