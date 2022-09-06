package com.sapient.oms.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OrderItemTest {

    @Mock
    OrderItem orderItem;

    static OrderItem checkOrderItem = new OrderItem();

    @BeforeAll
    static void setup() {
        // checkOrderItem.setId(1);
        checkOrderItem.setQuantity(1);
        checkOrderItem.setProduct(null);
        checkOrderItem.setPrice(20);
        checkOrderItem.setOrder(null);
    }

    // @Test
    // void testGetOrderItemId() {
    //     when(orderItem.getId()).thenReturn(checkOrderItem.getId());
    //     assertEquals(checkOrderItem.getId(), orderItem.getId());
    //     verify(orderItem, times(1)).getId();
    // }

    @Test
    void testGetOrderItemProduct() {
        when(orderItem.getProduct()).thenReturn(checkOrderItem.getProduct());
        assertEquals(checkOrderItem.getProduct(), orderItem.getProduct());
        verify(orderItem, times(1)).getProduct();
    }

    @Test
    void testGetOrderItemQuantity() {
        when(orderItem.getQuantity()).thenReturn(checkOrderItem.getQuantity());
        assertEquals(checkOrderItem.getQuantity(), orderItem.getQuantity());
        verify(orderItem, times(1)).getQuantity();
    }
    @Test
    void testGetOrderItemPrice() {
        when(orderItem.getPrice()).thenReturn(checkOrderItem.getPrice());
        assertEquals(checkOrderItem.getPrice(), orderItem.getPrice());
        verify(orderItem, times(1)).getPrice();
    }
    @Test
    void testGetOrderItemOrder() {
        when(orderItem.getOrder()).thenReturn(checkOrderItem.getOrder());
        assertEquals(checkOrderItem.getOrder(), orderItem.getOrder());
        verify(orderItem, times(1)).getOrder();
    }

}