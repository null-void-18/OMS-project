package com.sapient.oms.services;

import java.util.List;
import java.util.Optional;

import com.sapient.oms.entity.Product;

public interface IProductService {
    List<Product> getValue();
    Product save(Product product);
    void delete(Integer id);
    Optional<Product> findById(Integer id);
    Product findByName(String name);
}
