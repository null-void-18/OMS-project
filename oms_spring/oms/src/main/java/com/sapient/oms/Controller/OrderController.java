package com.sapient.oms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.oms.entity.Order;
import com.sapient.oms.enums.ORDER_STATUS;
import com.sapient.oms.exception.OrderNotFoundException;
import com.sapient.oms.services.IOrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired // dependecny injection
    IOrderService orderService;// never create object

    @GetMapping
    String getStore() {
        return orderService.getValue().toString();
    }

    @GetMapping("/id/{id}")
    public String findById(@PathVariable("id") Integer id) {
        try {
            Order order = orderService.findById(id);
            return order.toString();
        } catch (OrderNotFoundException e) {
            return e.getMessage();
        }
    }

    @GetMapping("/status/{status}")
    public List<Order> findByOrderStatus(@PathVariable("status") ORDER_STATUS orderStatus){
        return orderService.findByOrderStatus(orderStatus);
    }

    @PostMapping
    void save(@RequestBody Order order) {
        orderService.save(order);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Integer id) {
        orderService.delete(id);
    }
}
