package com.sapient.oms.Entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.sapient.oms.controller.ProductController;
import com.sapient.oms.entity.Product;
import com.sapient.oms.services.ProductService;


@SpringBootTest
public class ProductTest {
    @InjectMocks
    ProductController productController;

    @Mock
    ProductService productService;

    @Test
    void testGetProduct() {
        int id = 10;
        Product product = new Product(10, "chocolate", new Date(), new Date(), 40);
        when(productService.findById(id)).thenReturn(product);
        String actualResult = productController.findById(id);
        String expectedResult = product.toString();
        assertEquals(expectedResult, actualResult);
    }
}
