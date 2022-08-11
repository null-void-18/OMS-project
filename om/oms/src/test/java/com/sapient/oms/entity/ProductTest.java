package com.sapient.oms.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductTest {
    Product product;
    private static int id;
    private static String productName;
    private static double cost;

    @BeforeAll
    static void setup(){
        id = 1;
        productName = "Shampoo";
        cost = 190.25;
    }

    @BeforeEach
    void initialize() {
        product = new Product();
    }

    @Test
    void testId() {
        product.setId(1);
        assertEquals(id, product.getId());
    }

    @Test
    void testProductName() {
        product.setProductName("Shampoo");;
        assertEquals(productName, product.getProductName());
    }

    @Test
    void testCost() {
        product.setCost(190.25);
        assertEquals(cost, product.getCost());
    }
}
