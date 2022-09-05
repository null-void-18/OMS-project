package com.sapient.oms.services;

import java.util.List;

import com.sapient.oms.entity.OrderItem;
import com.sapient.oms.exception.OrderNotFoundException;

public interface IOrderItemService {
    List<OrderItem> findAll();
    List<OrderItem> findByOrderId(Integer orderId) throws OrderNotFoundException;
}
