package com.sapient.oms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.oms.entity.Product;
import com.sapient.oms.services.IInventoryService;
import com.sapient.oms.services.IProductService;
import com.sapient.oms.services.IStoreService;

@RestController
@RequestMapping("/oms/product")
public class ProductController {
    @Autowired // dependency injection
    IProductService productService;// never create object
    @Autowired
    IStoreService storeService;//
    @Autowired
    IInventoryService inventoryService;

    @PostMapping("/add-product/{id}")
    public Integer createProduct(@PathVariable("id") Integer id, @RequestBody Product product) {
        Product savedProduct = productService.createProduct(product);
        inventoryService.addProductToStore(id, savedProduct);

        return product.getId();

    }

    @GetMapping("/get-products")
    public List<Product> getProducts() {

        List<Product> products = productService.getAllProducts();
        return products;
    }

    @GetMapping("/get-products/{id}")
    public String getProductById(@PathVariable("id") Integer id) {
        Product product = productService.getProductById(id);
        return "Product: " + product;
    }

    @GetMapping("/get-products/name")
    public String getProductByName(@RequestParam String name) {
        List<Product> products = productService.findByName(name);
        return "Product: " + products;
    }

}
