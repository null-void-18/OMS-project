package com.sapient.oms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.oms.Entity.Order;
import com.sapient.oms.Services.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired  //dependecny injection
    OrderService orderService;// never create object
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
