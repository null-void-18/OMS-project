package com.sapient.oms.dto;

import javax.validation.constraints.NotNull;

public class InventoryDto {
    private @NotNull Integer storeId;
    private @NotNull Integer productId;
    private @NotNull Integer count;
    public InventoryDto(@NotNull Integer storeId, @NotNull Integer productId, @NotNull Integer count) {
        this.storeId = storeId;
        this.productId = productId;
        this.count = count;
    }
    public InventoryDto() {
    }
    public Integer getStoreId() {
        return storeId;
    }
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }
    public Integer getProductId() {
        return productId;
    }
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }

    
}
