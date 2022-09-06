package com.sapient.oms.services;

import java.util.List;

import com.sapient.oms.entity.Product;

public interface IProductService {
    Product createProduct(Product product);

    public List<Product> getAllProducts();

    public Product getProductById(int id);

    public List<Product> findByName(String name);

}
