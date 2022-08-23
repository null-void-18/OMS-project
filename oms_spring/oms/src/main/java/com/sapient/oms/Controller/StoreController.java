package com.sapient.oms.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.oms.Entity.Store;
import com.sapient.oms.Services.StoreService;

@RestController
@RequestMapping("/store")
public class StoreController {
    @Autowired  //dependecny injection
    StoreService storeService;// never create object
    @GetMapping
    String getStore() {
        return storeService.getValue().toString();
    }

    @PostMapping
    void save(@RequestBody Store store) {
        storeService.save(store);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Integer id){
        storeService.delete(id);
    }
}
