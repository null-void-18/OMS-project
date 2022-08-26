package com.sapient.oms.services;

import java.util.List;

import com.sapient.oms.entity.Product;

public interface IProductService {
    List<Product> getValue();
    int save(Product product);
    void delete(Integer id);
    Product findById(Integer id);
    Product findByName(String name);
}
