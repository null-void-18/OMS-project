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

import com.sapient.oms.entity.Store;
import com.sapient.oms.services.IStoreService;

@RestController
@RequestMapping("/store")
public class StoreController {
    @Autowired  //dependecny injection
    IStoreService storeService;// never create object
    @GetMapping
    List<Store> getStore() {
        return storeService.getValue();
    }

    @PostMapping
    public
    void save(@RequestBody Store store) {
        storeService.save(store);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Integer id){
        storeService.delete(id);
    }
}
