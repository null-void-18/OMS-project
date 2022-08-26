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
import com.sapient.oms.services.StoreService;

@RestController
@RequestMapping("/store")
public class StoreController {
    @Autowired  //dependecny injection
    StoreService storeService;// never create object
    @GetMapping
    List<Store> getStore() {
        return storeService.getValue();
    }

    @PostMapping
    public
    int save(@RequestBody Store store) {
        int id = storeService.save(store);
        return id;
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Integer id){
        storeService.delete(id);
    }
}
