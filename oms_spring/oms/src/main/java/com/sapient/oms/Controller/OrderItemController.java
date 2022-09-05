package com.sapient.oms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.oms.services.IOrderItemService;

@RestController
@RequestMapping("/orderitem")
public class OrderItemController {
    @Autowired
    IOrderItemService orderItemService;

    @GetMapping
    String findAll(){
        return orderItemService.findAll().toString();
    }

    @GetMapping("/{order}")
    String findByOrderId(@PathVariable("order") Integer orderId){
        try {
            return orderItemService.findByOrderId(orderId).toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
