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
class CartItemTest {

    @Mock
    CartItem cartItem;

    static CartItem checkCartItem = new CartItem();

    @BeforeAll
    static void setup() {
        checkCartItem.setId(1);
        checkCartItem.setQuantity(1);
        checkCartItem.setProduct(null);
    }

    @Test
    void testGetCartId() {
        when(cartItem.getId()).thenReturn(checkCartItem.getId());
        assertEquals(checkCartItem.getId(), cartItem.getId());
        verify(cartItem, times(1)).getId();
    }

    @Test
    void testGetProduct() {
        when(cartItem.getProduct()).thenReturn(checkCartItem.getProduct());
        assertEquals(checkCartItem.getProduct(), cartItem.getProduct());
        verify(cartItem, times(1)).getProduct();
    }

    @Test
    void testGetQuantity() {
        when(cartItem.getQuantity()).thenReturn(checkCartItem.getQuantity());
        assertEquals(checkCartItem.getQuantity(), cartItem.getQuantity());
        verify(cartItem, times(1)).getQuantity();
    }

}