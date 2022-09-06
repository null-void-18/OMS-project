package com.sapient.oms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.oms.dto.InventoryDto;
import com.sapient.oms.entity.Inventory;
import com.sapient.oms.entity.Product;
import com.sapient.oms.services.IInventoryService;

@RestController
@RequestMapping("/oms/inventory")
public class InventoryController {
    @Autowired // dependency injection
    IInventoryService inventoryService;// never create object

    @PutMapping("/add")
    public Inventory updateInventoryToAdd(@RequestBody InventoryDto inventory) {
        return inventoryService.updateProductToAdd(inventory);

    }

    @PutMapping("/remove")
    public Inventory updateInventoryToRemove(@RequestBody InventoryDto inventory) {
        return inventoryService.updateProductToRemove(inventory);

    }

    @GetMapping("")
    public List<Product> getInventory() {
        return inventoryService.getItems();
    }

    @GetMapping("/{id}")
    public List<Product> getProductById(@PathVariable("id") Integer id) {
        return inventoryService.getProduct(id);
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable("id") Integer id) {
        inventoryService.removeProductFromInventory(id);
        return "Product deleted successfully from inventory";
    }

}
