package com.sapient.oms.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "orderitem")
public class OrderItem {
    @EmbeddedId
    private OrderItemId id = new OrderItemId();
    @ManyToOne
    @MapsId(value = "orderId")
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne
    @MapsId(value = "productId")
    @JoinColumn(name = "product_id")
    private Product product;
    private int quantity;
    private int price;

    public OrderItem() {
    }

    public OrderItem(OrderItemId id, int quantity, int price) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
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

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((order == null) ? 0 : order.hashCode());
        result = prime * result + price;
        result = prime * result + ((product == null) ? 0 : product.hashCode());
        result = prime * result + quantity;
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
        OrderItem other = (OrderItem) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (order == null) {
            if (other.order != null)
                return false;
        } else if (!order.equals(other.order))
            return false;
        if (price != other.price)
            return false;
        if (product == null) {
            if (other.product != null)
                return false;
        } else if (!product.equals(other.product))
            return false;
        if (quantity != other.quantity)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "OrderItems [Products " + product  + ", quantity=" + quantity + "]";
    } 
}
