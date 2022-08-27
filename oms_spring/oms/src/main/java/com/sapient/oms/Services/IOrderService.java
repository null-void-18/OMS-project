package com.sapient.oms.services;

import java.util.List;
import com.sapient.oms.entity.Order;

public interface IOrderService {
    List<Order> getValue();
    Order save(Order order);
    void delete(Integer id);
}
