package com.sapient.oms.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.oms.entity.Order;
import com.sapient.oms.entity.OrderItem;
import com.sapient.oms.enums.ORDER_STATUS;
import com.sapient.oms.exception.OrderNotFoundException;
import com.sapient.oms.services.IOrderService;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired // dependecny injection
    IOrderService orderService;// never create object

    @GetMapping
    List<Order> getStore() {
        return orderService.getValue();
    }

    @GetMapping("/item/{order}")
    Collection<OrderItem> getItems(@PathVariable("order") Integer orderId) {
            try{
                return orderService.findById(orderId).getOrderitems();
            }catch(Exception e){
                System.out.println(e.getMessage());
                return new ArrayList<OrderItem>();
            }
    }

    @GetMapping("/id/{id}")
    public Order findById(@PathVariable("id") Integer id) {
        try {
            Order order = orderService.findById(id);
            return order;
        } catch (OrderNotFoundException e) {
            System.out.println(e.getMessage());
            return new Order();
        }
    }

    @GetMapping("/status/{status}")
    public List<Order> findByOrderStatus(@PathVariable("status") ORDER_STATUS orderStatus){
        if(orderStatus == ORDER_STATUS.ALL) {
            return orderService.getValue();
        }
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
