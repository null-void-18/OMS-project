package com.sapient.oms.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class Inventory implements Serializable  {

    @Id
    int id;

    @ManyToOne
    @MapsId("storeid")
    @JoinColumn(name = "store_id")
    Store store;

 
    @ManyToOne
    @MapsId("productid")
    @JoinColumn(name = "product_id")
    Product product;
    int count;
    
    public Store getStore() {
        return store;
    }
    public void setStore(Store store) {
        this.store = store;
    }
    public Product getProduct() {
        return product;
    }
    public Inventory() {
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }
    public Inventory(Store store, Product product, int count) {
        this.store = store;
        this.product = product;
        this.count = count;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
   
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + count;
        result = prime * result + ((product == null) ? 0 : product.hashCode());
        result = prime * result + ((store == null) ? 0 : store.hashCode());
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
        Inventory other = (Inventory) obj;
        if (count != other.count)
            return false;
        if (product == null) {
            if (other.product != null)
                return false;
        } else if (!product.equals(other.product))
            return false;
        if (store == null) {
            if (other.store != null)
                return false;
        } else if (!store.equals(other.store))
            return false;
        return true;
    }
}
