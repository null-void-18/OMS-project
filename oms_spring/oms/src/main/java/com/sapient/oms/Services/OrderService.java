package com.sapient.oms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.oms.entity.Order;
import com.sapient.oms.repositories.OrderRepository;


@Service
public class OrderService implements IService<Order> {
    @Autowired
    OrderRepository orderRepository;

    public void delete(Integer id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<Order> getValue() {
        return orderRepository.findAll();
    }

    @Override
    public void save(Order entity) {
        orderRepository.save(entity);
    }

}
