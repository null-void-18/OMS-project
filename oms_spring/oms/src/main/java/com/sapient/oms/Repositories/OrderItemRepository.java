package com.sapient.oms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.oms.entity.OrderItem;
import com.sapient.oms.entity.OrderItemId;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,OrderItemId>{
    List<OrderItem> findByIdOrderId(int orderId);
}
