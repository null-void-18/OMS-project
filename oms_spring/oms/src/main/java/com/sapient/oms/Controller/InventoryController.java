package com.sapient.oms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.oms.services.IInventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    IInventoryService inventoryService;

    @GetMapping
    String findAll(){
        return inventoryService.findAll().toString();
    }

    @GetMapping("/{store}")
    String findByStoreId(@PathVariable("store") Integer storeId){
        try {
            return inventoryService.findByStoreId(storeId).toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @PatchMapping("/{storeId}/{productId}/{quantity}")
    String updateQuantity(@PathVariable("storeId") Integer storeId,@PathVariable("productId") Integer productId,@PathVariable("quantity") int quantity) {
        return inventoryService.updateQuantity(storeId, productId, quantity);
    }
}
