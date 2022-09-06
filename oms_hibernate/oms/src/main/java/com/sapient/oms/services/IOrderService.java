package com.sapient.oms.services;

import java.util.List;

import com.sapient.oms.dto.OrderDto;
import com.sapient.oms.entity.Order;
import com.sapient.oms.entity.OrderItem;

public interface IOrderService {

    Order addOrder(OrderDto order);

    Order getOrder(Integer orderid);

    List<OrderItem> getOrderItems(Integer orderId);

    List<Order> getOrdersByUserId(Integer userId);

    List<Order> getOrdersByStoreId(Integer storeId);

}
