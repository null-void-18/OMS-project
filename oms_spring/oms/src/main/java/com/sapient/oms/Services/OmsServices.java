package com.sapient.oms.Services;

import java.util.List;

import com.sapient.oms.Entity.Product;

public interface OmsServices {

    abstract void placeOrder();
    abstract void addToCart(List<Product> products);
    abstract void updateOrder(Integer id);
    abstract void deleteOrder(Integer id);
    abstract void sendNotification(String email);
}
