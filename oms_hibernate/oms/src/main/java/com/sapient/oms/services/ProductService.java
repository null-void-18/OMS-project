package com.sapient.oms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.oms.ecxeptions.ProductNotFoundException;
import com.sapient.oms.entity.Product;
import com.sapient.oms.repository.ProductRepository;

@Service
public class ProductService implements IProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    InventoryService inventoryService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Product createProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Product getProductById(int id) throws ProductNotFoundException {
        Optional<Product> product = productRepository.findById(id);
        if (!product.isPresent()) {
            throw new ProductNotFoundException("Product Not Found with id:" + id);
        }
        return product.get();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Product> findByName(String name) throws ProductNotFoundException {
        List<Product> products = productRepository.findByName(name);
        if (products.isEmpty()) {
            throw new ProductNotFoundException("Product Not Found with name:" + name);
        }

        return products;
    }

}
