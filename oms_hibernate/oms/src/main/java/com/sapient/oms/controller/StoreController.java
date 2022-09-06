package com.sapient.oms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.oms.entity.Store;
import com.sapient.oms.services.IStoreService;

@RestController
@RequestMapping("/oms/store")
public class StoreController {
    @Autowired // dependency injection
    IStoreService storeService;// never create object

    @GetMapping("/get-stores")
    public String getStores() {

        List<Store> stores = storeService.getAllStores();
        return "Stores: " + stores;
    }

    @GetMapping("/get-stores/{id}")
    public String getStoreById(@PathVariable("id") Integer id) {

        Store store = storeService.getStoreById(id);
        return "Store: " + store;
    }

}
