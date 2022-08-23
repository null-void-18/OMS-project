package com.sapient.oms.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sapient.oms.Entity.Product;
import com.sapient.oms.Services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired  //dependecny injection
    ProductService productService;// never create object
    @GetMapping
    String getStore() {
        return productService.getValue().toString();
    }

    @PostMapping
    void save(@RequestBody Product product) {
        productService.save(product);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Integer id){
        productService.delete(id);
    }
}