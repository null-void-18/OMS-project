package com.sapient.oms.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.oms.Entity.Store;
import com.sapient.oms.Services.IStoreService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/store")
public class StoreController {
    @Autowired  //dependecny injection
    IStoreService storeService;// never create object
    @GetMapping
    String getStore() {
        log.debug("called");
        return storeService.getStore().toString();
        //return "hello controller";
    }

    @PostMapping
    void save(@RequestBody Store store) throws IOException {
        storeService.save(store);
        System.out.println("post called   "+store.getShopName());
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Integer id){
        storeService.delete(id);
    }
}
