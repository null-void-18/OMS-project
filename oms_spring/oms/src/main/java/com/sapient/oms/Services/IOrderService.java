package com.sapient.oms.services;

import java.util.List;

import com.sapient.oms.entity.Order;
import com.sapient.oms.enums.ORDER_STATUS;

public interface IOrderService {
    List<Order> getValue();
    Order save(Order order);
    void delete(Integer id);
    Order findById(Integer id);
    List<Order> findByOrderStatus(ORDER_STATUS orderStatus);
}
