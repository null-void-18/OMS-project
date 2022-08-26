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
import com.sapient.oms.services.IOrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired  //dependecny injection
    IOrderService orderService;// never create object
    @GetMapping
    List<Order> getStore() {
        return orderService.getValue();
    }

    @PostMapping
    void save(@RequestBody Order order) {
        orderService.save(order);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Integer id){
        orderService.delete(id);
    }
}
