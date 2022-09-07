package com.sapient.oms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.oms.entity.OrderItem;
import com.sapient.oms.services.IOrderItemService;
@CrossOrigin
@RestController
@RequestMapping("/orderitem")
public class OrderItemController {
    @Autowired
    IOrderItemService orderItemService;

    @GetMapping
    List<OrderItem> findAll(){
        return orderItemService.findAll();
    }

    @GetMapping("/{order}")
    List<OrderItem> findByOrderId(@PathVariable("order") Integer orderId){
        try {
            return orderItemService.findByOrderId(orderId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<OrderItem>();
        }
    }
}
