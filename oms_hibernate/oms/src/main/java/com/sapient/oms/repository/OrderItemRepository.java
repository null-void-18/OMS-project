package com.sapient.oms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sapient.oms.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

}
