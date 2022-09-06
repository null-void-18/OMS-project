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
class StoreTest {

    @Mock
    Store store;

    static Store checkStore = new Store();

    @BeforeAll
    static void setup() {
        checkStore.setId(1);
        checkStore.setAddress(new Address());
        checkStore.setEmail("rachitsinghal40@gmail.com");
        checkStore.setName("Rachit Singhal");
        checkStore.setPhoneNumber("7906593176");
        checkStore.setOpeningTime("10:00 AM");
        checkStore.setClosingTime("6:00 PM");
        checkStore.setOrders(null);
    }

    @Test
    void testGetAddress() {
        when(store.getAddress()).thenReturn(checkStore.getAddress());
        assertEquals(checkStore.getAddress(), store.getAddress());
        verify(store, times(1)).getAddress();
    }

    @Test
    void testGetStoreEmail() {
        when(store.getEmail()).thenReturn(checkStore.getEmail());
        assertEquals(checkStore.getEmail(), store.getEmail());
        verify(store, times(1)).getEmail();
    }

    @Test
    void testGetStoreId() {
        when(store.getId()).thenReturn(checkStore.getId());
        assertEquals(checkStore.getId(), store.getId());
        verify(store, times(1)).getId();
    }

    @Test
    void testGetStoreName() {
        when(store.getName()).thenReturn(checkStore.getName());
        assertEquals(checkStore.getName(), store.getName());
        verify(store, times(1)).getName();
    }

    @Test
    void testGetStorePhone() {
        when(store.getPhoneNumber()).thenReturn(checkStore.getPhoneNumber());
        assertEquals(checkStore.getPhoneNumber(), store.getPhoneNumber());
        verify(store, times(1)).getPhoneNumber();
    }

    @Test
    void testGetOrders() {
        when(store.getOrders()).thenReturn(checkStore.getOrders());
        assertEquals(checkStore.getOrders(), store.getOrders());
        verify(store, times(1)).getOrders();
    }

    @Test
    void testGetOpeningTime() {
        when(store.getOpeningTime()).thenReturn(checkStore.getOpeningTime());
        assertEquals(checkStore.getOpeningTime(), store.getOpeningTime());
        verify(store, times(1)).getOpeningTime();
    }

    @Test
    void testGetClosingTime() {
        when(store.getClosingTime()).thenReturn(checkStore.getClosingTime());
        assertEquals(checkStore.getClosingTime(), store.getClosingTime());
        verify(store, times(1)).getClosingTime();
    }

}