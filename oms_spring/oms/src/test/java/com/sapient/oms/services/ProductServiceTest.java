package com.sapient.oms.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sapient.oms.entity.Inventory;
import com.sapient.oms.entity.Product;
import com.sapient.oms.exception.ProductNotFoundException;
import com.sapient.oms.repositories.ProductRepository;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    
    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService;

    private Product expectedProduct;

    @BeforeEach
    void setup() {
        expectedProduct = new Product();
        expectedProduct.setId(10);
        expectedProduct.setProductName("chocolate");
        expectedProduct.setCost(40);
        expectedProduct.setMdate(new Date());
        expectedProduct.setEdate(new Date());
        expectedProduct.setInventory(new HashSet<Inventory>());
    }

    @Test
    void testSaveProduct() {
        Product product = new Product(10, "chocolate", new Date(), new Date(), 40,new HashSet<Inventory>());
        when(productRepository.save(any(Product.class))).thenReturn(product);
        Product actualProduct = productService.save(product);
        assertEquals(actualProduct, expectedProduct);
    }

    @Test
    void testFindProductByIdExists() {
        Product product = new Product(10, "chocolate", new Date(), new Date(), 40,new HashSet<Inventory>());
        Optional<Product> product1 = Optional.of(product);
        when(productRepository.findById(10)).thenReturn(product1);
        Product actualProduct = productService.findById(10);
        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    void testFindProductByIdDoesNotExist() {
        Optional<Product> product = Optional.empty();
        when(productRepository.findById(10)).thenReturn(product);
        assertThrows(ProductNotFoundException.class,() -> productService.findById(10));
    }

    @Test
    void testFindProductByNameExists() {
        Product product = new Product(10, "chocolate", new Date(), new Date(), 40,new HashSet<Inventory>());
        List<Product> products = new ArrayList<>();
        products.add(product);
        when(productRepository.findAll()).thenReturn(products);
        Product actualProduct = productService.findByName("chocolate");
        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    void testFindProductByNameDoesNotExist() {
        Product product = new Product(10, "chocolate", new Date(), new Date(), 40,new HashSet<Inventory>());
        List<Product> products = new ArrayList<>();
        products.add(product);
        when(productRepository.findAll()).thenReturn(products);
        assertThrows(ProductNotFoundException.class,() -> productService.findByName("biscuit"));
    }
}
