package com.sapient.oms.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;

@Entity
@AssociationOverrides({
    @AssociationOverride(name = "id.product", 
        joinColumns = @JoinColumn(name = "product_id")),
    @AssociationOverride(name = "id.store", 
        joinColumns = @JoinColumn(name = "store_id")) })
public class Inventory {
    @EmbeddedId
    private InventoryId id = new InventoryId();
    @Column(name = "quantity", nullable = false)
    private int quantity;
 
    public Inventory() { 
    }

    
    public Inventory(InventoryId id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

   
    public InventoryId getPk() {
        return id;
    }

    public void setPk(InventoryId id) {
        this.id = id;
    }

    @Transient
    public Store getStore() {
        return getPk().getStore();
    }

    @Transient
    public Product getProduct() {
        return getPk().getProduct();
    }
    
}
