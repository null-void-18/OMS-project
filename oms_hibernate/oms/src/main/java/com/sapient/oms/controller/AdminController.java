package com.sapient.oms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.oms.entity.Store;
import com.sapient.oms.services.IAdminService;

@RestController
@RequestMapping("/oms")
public class AdminController {
    @Autowired // dependency injection
    IAdminService adminService;// never create object

    @GetMapping
    public String getUser() {
        return "Hello Controller";
    }

    @PostMapping("/add-store")
    public int createStore(@RequestBody Store store) {
        int savedStore = adminService.createStore(store);
        return savedStore;

    }

}
