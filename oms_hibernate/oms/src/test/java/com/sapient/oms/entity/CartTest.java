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
class CartTest {

    @Mock
    Cart cart;

    static Cart checkCart=new Cart();

    @BeforeAll
    static void setup(){
        checkCart.setId(1);
        checkCart.setCreatedDate(new Date());
        checkCart.setStoreId(1);
        checkCart.setUser(null);
        checkCart.setCartItems(null);
    }

    @Test
    void testGetCartId() {
        when(cart.getId()).thenReturn(checkCart.getId());
        assertEquals(checkCart.getId(), cart.getId());
        verify(cart, times(1)).getId();
    }

    @Test
    void testGetUser() {
        when(cart.getUser()).thenReturn(checkCart.getUser());
        assertEquals(checkCart.getUser(), cart.getUser());
        verify(cart, times(1)).getUser();
    }

    @Test
    void testGetStoreId() {
        when(cart.getStoreId()).thenReturn(checkCart.getStoreId());
        assertEquals(checkCart.getStoreId(), cart.getStoreId());
        verify(cart, times(1)).getStoreId();
    }

    @Test
    void testGetCreatedDate() {
        when(cart.getCreatedDate()).thenReturn(checkCart.getCreatedDate());
        assertEquals(checkCart.getCreatedDate(), cart.getCreatedDate());
        verify(cart, times(1)).getCreatedDate();
    }
    @Test
    void testGetCartIems() {
        when(cart.getCartItems()).thenReturn(checkCart.getCartItems());
        assertEquals(checkCart.getCartItems(), cart.getCartItems());
        verify(cart, times(1)).getCartItems();
    }

}