package com.sapient.oms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.oms.entity.Inventory;
import com.sapient.oms.services.IInventoryService;

@CrossOrigin
@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    IInventoryService inventoryService;

    @GetMapping
    List<Inventory> findAll(){
        return inventoryService.findAll();
    }

    @GetMapping("/{store}")
    List<Inventory> findByStoreId(@PathVariable("store") Integer storeId){
        try {
            return inventoryService.findByStoreId(storeId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<Inventory>();
        }
    }

    @PatchMapping("/{storeId}/{productId}/{quantity}")
    String updateQuantity(@PathVariable("storeId") Integer storeId,@PathVariable("productId") Integer productId,@PathVariable("quantity") int quantity) {
        return inventoryService.updateQuantity(storeId, productId, quantity);
    }
}
