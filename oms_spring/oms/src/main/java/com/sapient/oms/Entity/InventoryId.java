package com.sapient.oms.entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class InventoryId implements java.io.Serializable{
    @ManyToOne
    private Store store;
    @ManyToOne
    private Product product;

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
}
