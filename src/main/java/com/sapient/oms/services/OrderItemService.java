package com.sapient.oms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.oms.entity.OrderItem;
import com.sapient.oms.exception.OrderNotFoundException;
import com.sapient.oms.repositories.OrderItemRepository;

@Service
public class OrderItemService implements IOrderItemService{
    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    OrderService orderService;

    @Override
    public List<OrderItem> findAll() {
        return orderItemRepository.findAll();
    }

    @Override
    public List<OrderItem> findByOrderId(Integer orderId) throws OrderNotFoundException{
        orderService.findById(orderId);
        return orderItemRepository.findByIdOrderId(orderId.intValue());
    }

}
