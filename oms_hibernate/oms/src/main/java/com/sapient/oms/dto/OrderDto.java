package com.sapient.oms.dto;

import javax.validation.constraints.NotNull;

import com.sapient.oms.entity.Order;

public class OrderDto {
    private Integer id;
    private @NotNull Integer userId;
    private @NotNull Integer storeId;
    private @NotNull Double totalPrice;

    public OrderDto(@NotNull Integer userId, @NotNull Integer storeId, @NotNull Double totalPrice) {
        this.userId = userId;
        this.storeId = storeId;
        this.totalPrice = totalPrice;
    }

    public OrderDto() {
    }

    public OrderDto(Order order) {
        this.setId(order.getId());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

}
