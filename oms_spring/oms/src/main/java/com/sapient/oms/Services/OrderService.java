package com.sapient.oms.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.oms.entity.Order;
import com.sapient.oms.enums.ORDER_STATUS;
import com.sapient.oms.exception.OrderNotFoundException;
import com.sapient.oms.repositories.OrderRepository;

@Service
public class OrderService implements IOrderService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public void delete(Integer id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<Order> getValue() {
        return orderRepository.findAll();
    }

    @Override
    public Order save(Order entity) {
        return orderRepository.save(entity);
    }

    @Override
    public List<Order> findByOrderStatus(ORDER_STATUS orderStatus) {
        List<Order> allOrders = orderRepository.findAll();
        List<Order> orders = new ArrayList<>();
        for (Order order : allOrders) {
            if (order.getOrderStatus() == orderStatus) {
                orders.add(order);
            }
        }
        return orders;
    }

    @Override
    public Optional<Order> findById(Integer id) throws OrderNotFoundException {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isEmpty()) {
            throw new OrderNotFoundException("Order id=" + id + " not found");
        }
        return order;
    }
}
