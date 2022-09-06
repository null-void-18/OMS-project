package com.sapient.oms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.oms.dto.OrderDto;
import com.sapient.oms.entity.Order;
import com.sapient.oms.entity.OrderItem;
import com.sapient.oms.services.IOrderService;

@RestController
@RequestMapping("/oms/order")
public class OrderController {

    @Autowired
    IOrderService orderService;

    @PostMapping("/")
    public Order addOrder(@RequestBody OrderDto order) {

        Order savedOrder = orderService.addOrder(order);
        return savedOrder;

    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable("id") Integer id) {

        Order order = orderService.getOrder(id);
        return order;
    }

    @GetMapping("/orderitems/{id}")
    public List<OrderItem> getOrderItems(@PathVariable("id") Integer id) {

        return orderService.getOrderItems(id);
    }

    @GetMapping("/user/{id}")
    public List<Order> getOrderByUser(@PathVariable("id") Integer id) {

        return orderService.getOrdersByUserId(id);
    }

    @GetMapping("/store/{id}")
    public List<Order> getOrderByStore(@PathVariable("id") Integer id) {

        return orderService.getOrdersByStoreId(id);
    }

}
