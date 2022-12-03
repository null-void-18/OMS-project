package com.sapient.oms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired  //dependecny injection
    IProductService productService;// never create object
    @GetMapping
    List<Product> getProduct() {
        return productService.getValue();
    }

    @PostMapping
    void save(@RequestBody Product product) {
        productService.save(product);
    }

    @GetMapping("/id/{id}")
    public
    Product findById(@PathVariable("id") Integer id) {
        try {
            Product product = productService.findById(id);
            return product;
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
            return new Product();
        } 
    }

    @GetMapping("/name/{productName}")
    Product findByName(@PathVariable("productName") String name) {
        try {
            Product product = productService.findByName(name);
            return product;
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
            return new Product();
        }
    }


    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Integer id){
        productService.delete(id);
    }  
}