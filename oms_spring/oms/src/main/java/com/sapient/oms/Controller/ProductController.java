package com.sapient.oms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.oms.entity.Product;
import com.sapient.oms.exception.ProductNotFoundException;
import com.sapient.oms.services.IProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired  //dependecny injection
    IProductService productService;// never create object
    @GetMapping
    String getProduct() {
        return productService.getValue().toString();
    }

    @PostMapping
    void save(@RequestBody Product product) {
        productService.save(product);
    }

    @GetMapping("/id/{id}")
    public
    String findById(@PathVariable("id") Integer id) {
        try {
            Product product = productService.findById(id);
            return product.toString();
        } catch (ProductNotFoundException e) {
            return e.getMessage();
        } 
    }

    @GetMapping("/name/{productName}")
    String findByName(@PathVariable("productName") String name) {
        try {
            Product product = productService.findByName(name);
            return product.toString();
        } catch (ProductNotFoundException e) {
            return e.getMessage();
        }
    }


    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Integer id){
        productService.delete(id);
    }  
}