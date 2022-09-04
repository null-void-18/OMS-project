package com.sapient.oms.entity;

import javax.persistence.Embeddable;

@Embeddable
public class InventoryId implements java.io.Serializable{
    private int productId;
    private int storeId;
    public InventoryId(int storeId,int productId) {
        this.storeId = storeId;
        this.productId = productId;
    }
    public InventoryId() {
    }
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public int getStoreId() {
        return storeId;
    }
    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + productId;
        result = prime * result + storeId;
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
        InventoryId other = (InventoryId) obj;
        if (productId != other.productId)
            return false;
        if (storeId != other.storeId)
            return false;
        return true;
    } 
    
}
