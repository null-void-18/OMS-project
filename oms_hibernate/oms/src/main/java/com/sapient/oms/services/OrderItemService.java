package com.sapient.oms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.oms.entity.OrderItem;
import com.sapient.oms.repository.OrderItemRepository;

@Service
public class OrderItemService implements IOrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderItem addOrderedProducts(OrderItem orderItem) {
        OrderItem savedOrderItem = orderItemRepository.save(orderItem);
        return savedOrderItem;
    }

}
