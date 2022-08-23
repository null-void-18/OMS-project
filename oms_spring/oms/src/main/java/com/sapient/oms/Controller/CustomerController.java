package com.sapient.oms.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.oms.Entity.Customer;
import com.sapient.oms.Services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired  //dependecny injection
    CustomerService customerService;// never create object
    @GetMapping
    String getStore() {
        return customerService.getValue().toString();
    }

    @PostMapping
    void save(@RequestBody Customer customer) {
        customerService.save(customer);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Integer id){
        customerService.delete(id);
    }
}
