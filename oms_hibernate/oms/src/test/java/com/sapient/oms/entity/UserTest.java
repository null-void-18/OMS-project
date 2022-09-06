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
class UserTest {

    @Mock
    User user;

    static User checkUser = new User();

    @BeforeAll
    static void setup() {
        checkUser.setId(1);
        checkUser.setFirstName("Rachit");
        checkUser.setAddress(new Address());
        checkUser.setLastName("Singhal");
        checkUser.setEmail("rachitsinghal40@gmail.com");
        checkUser.setPassword("apple");
        checkUser.setCart(null);
        checkUser.setOrders(null);
    }

    @Test
    void testGetuserAddresses() {
        when(user.getAddress()).thenReturn(checkUser.getAddress());
        assertEquals(checkUser.getAddress(), user.getAddress());
        verify(user, times(1)).getAddress();
    }

    @Test
    void testGetuserId() {
        when(user.getId()).thenReturn(checkUser.getId());
        assertEquals(checkUser.getId(), user.getId());
        verify(user, times(1)).getId();
    }

    @Test
    void testGetEmail() {
        when(user.getEmail()).thenReturn(checkUser.getEmail());
        assertEquals(checkUser.getEmail(), user.getEmail());
        verify(user, times(1)).getEmail();
    }

    @Test
    void testGetFirstName() {
        when(user.getFirstName()).thenReturn(checkUser.getFirstName());
        assertEquals(checkUser.getFirstName(), user.getFirstName());
        verify(user, times(1)).getFirstName();
    }

    @Test
    void testGetLastName() {
        when(user.getLastName()).thenReturn(checkUser.getLastName());
        assertEquals(checkUser.getLastName(), user.getLastName());
        verify(user, times(1)).getLastName();
    }

    @Test
    void testGetPassword() {
        when(user.getPassword()).thenReturn(checkUser.getPassword());
        assertEquals(checkUser.getPassword(), user.getPassword());
        verify(user, times(1)).getPassword();
    }

    @Test
    void testGetPhone() {
        when(user.getPhoneNumber()).thenReturn(checkUser.getPhoneNumber());
        assertEquals(checkUser.getPhoneNumber(), user.getPhoneNumber());
        verify(user, times(1)).getPhoneNumber();
    }

    @Test
    void testGetUserCart() {
        when(user.getCart()).thenReturn(checkUser.getCart());
        assertEquals(checkUser.getCart(), user.getCart());
        verify(user, times(1)).getCart();
    }

    @Test
    void testGetUserOrders() {
        when(user.getOrders()).thenReturn(checkUser.getOrders());
        assertEquals(checkUser.getOrders(), user.getOrders());
        verify(user, times(1)).getOrders();
    }

}