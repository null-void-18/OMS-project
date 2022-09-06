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
class InventoryTest {

    @Mock
    Inventory inventory;

    static Inventory checkInventory = new Inventory();

    @BeforeAll
    static void setup() {
        checkInventory.setStore(null);
        checkInventory.setProduct(null);
        checkInventory.setId(new InventoryKey(1, 2));
        checkInventory.setCount(5);
    }

    @Test
    void testGetInventoryKeyId() {
        when(inventory.getId()).thenReturn(checkInventory.getId());
        assertEquals(checkInventory.getId(), inventory.getId());
        verify(inventory, times(1)).getId();
    }

    @Test
    void testGetProduct() {
        when(inventory.getProduct()).thenReturn(checkInventory.getProduct());
        assertEquals(checkInventory.getProduct(), inventory.getProduct());
        verify(inventory, times(1)).getProduct();
    }

    @Test
    void testGetCount() {
        when(inventory.getCount()).thenReturn(checkInventory.getCount());
        assertEquals(checkInventory.getCount(), inventory.getCount());
        verify(inventory, times(1)).getCount();
    }

    @Test
    void testGetStore() {
        when(inventory.getStore()).thenReturn(checkInventory.getStore());
        assertEquals(checkInventory.getStore(), inventory.getStore());
        verify(inventory, times(1)).getStore();
    }

}