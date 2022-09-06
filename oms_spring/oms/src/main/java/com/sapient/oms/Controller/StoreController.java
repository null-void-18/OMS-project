package com.sapient.oms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.oms.entity.Store;
import com.sapient.oms.services.IStoreService;

@CrossOrigin
@RestController
@RequestMapping("/store")
public class StoreController {
    @Autowired // dependecny injection
    IStoreService storeService;// never create object

    @GetMapping
    String getStore() {
        return storeService.getValue().toString();
    }

    @GetMapping("/{store}")
    String findByStoreId(@PathVariable("store") Integer storeId) {
        try {
            return storeService.findById(storeId);
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    @PostMapping
    public void save(@RequestBody Store store) {
        storeService.save(store);
    }

    @PostMapping("/{store}/{product}/{quantity}")
    public String addProduct(@PathVariable("store") Integer storeId, @PathVariable("product") Integer productId,
            @PathVariable("quantity") Integer quantity) {
        try {
            storeService.addProduct(storeId, productId, quantity);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Product added to store" + storeId;
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Integer id) {
        storeService.delete(id);
    }
}
