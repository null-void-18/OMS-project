package com.sapient.oms.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sapient.oms.Entity.Product;
import com.sapient.oms.Repositories.ProductRepository;


@Service
public class ProductService implements IService<Product> {
    @Autowired
    ProductRepository productRepository;

    public void delete(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getValue() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product entity) {
        productRepository.save(entity);
    }

}
