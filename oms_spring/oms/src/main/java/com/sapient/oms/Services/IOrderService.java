package com.sapient.oms.services;

import java.util.List;
import java.util.Optional;

import com.sapient.oms.entity.Order;

public interface IOrderService {
    List<Order> getValue();
    Order save(Order order);
    void delete(Integer id);
    Optional<Order> findById(Integer id);
}
