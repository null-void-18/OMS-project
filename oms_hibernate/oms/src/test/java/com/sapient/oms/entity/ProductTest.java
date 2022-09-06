package com.sapient.oms.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProductTest {

    @Mock
    Product product;

    static Product checkProduct = new Product();

    @BeforeAll
    static void setup() {
        checkProduct.setId(1);
        checkProduct.setDescription("Description for Product");
        checkProduct.setName("Apple");
        checkProduct.setPrice(35.0F);
        checkProduct.setRatings(5);
        checkProduct.setManufacturingDate(new Date());
        ;

    }

    @Test
    void testGetProductId() {
        when(product.getId()).thenReturn(checkProduct.getId());
        assertEquals(checkProduct.getId(), product.getId());
        verify(product, times(1)).getId();
    }

    @Test
    void testGetPrice() {
        when(product.getPrice()).thenReturn(checkProduct.getPrice());
        assertEquals(checkProduct.getPrice(), product.getPrice(), 0f);
        verify(product, times(1)).getPrice();
    }

    @Test
    void testGetProductDescription() {
        when(product.getDescription()).thenReturn(checkProduct.getDescription());
        assertEquals(checkProduct.getDescription(), product.getDescription());
        verify(product, times(1)).getDescription();
    }

    @Test
    void testGetProductName() {
        when(product.getName()).thenReturn(checkProduct.getName());
        assertEquals(checkProduct.getName(), product.getName());
        verify(product, times(1)).getName();
    }

    @Test
    void testGetProductRatings() {
        when(product.getRatings()).thenReturn(checkProduct.getRatings());
        assertEquals(checkProduct.getRatings(), product.getRatings(), 0f);
        verify(product, times(1)).getRatings();
    }

    @Test
    void testGetProductManufacturingDate() {
        when(product.getManufacturingDate()).thenReturn(checkProduct.getManufacturingDate());
        assertEquals(checkProduct.getManufacturingDate(), product.getManufacturingDate());
        verify(product, times(1)).getManufacturingDate();
    }

}