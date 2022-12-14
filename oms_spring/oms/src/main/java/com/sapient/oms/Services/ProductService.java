package com.sapient.oms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.oms.entity.Product;
import com.sapient.oms.exception.ProductNotFoundException;
import com.sapient.oms.repositories.ProductRepository;


@Service
public class ProductService implements IProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getValue() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product entity) {
        return productRepository.save(entity);
    }

    @Override
    public Product findById(Integer id) throws ProductNotFoundException {
        Product product = productRepository.findById(id).orElse(null);
        if(product == null) {
            throw new ProductNotFoundException("Product id="+id+" not found");
        }
        return product;
    }

    @Override
    public Product findByName(String name) throws ProductNotFoundException {
        List<Product> products = productRepository.findAll();

        for(Product product : products) {
            if(product.getProductName().equals(name)){
                return product;
            }
         }
         throw new ProductNotFoundException("Product "+name+" not found");
    }

}
