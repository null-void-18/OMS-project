package com.sapient.oms.entity;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class InventoryKeyTest {
    
    @Mock
    InventoryKey inventoryKey;

    static InventoryKey checkInventoryKey=new InventoryKey();

    @BeforeAll
    static void setup() {
        checkInventoryKey.setProductid(2);
        checkInventoryKey.setStoreid(4);
    }
    
    @Test
    void testGetProductId() {
        when(inventoryKey.getProductid()).thenReturn(checkInventoryKey.getProductid());
        assertEquals(checkInventoryKey.getProductid(), inventoryKey.getProductid());
        verify(inventoryKey, times(1)).getProductid();
    }

    @Test
    void testGetStoreId() {
        when(inventoryKey.getStoreid()).thenReturn(checkInventoryKey.getStoreid());
        assertEquals(checkInventoryKey.getStoreid(), inventoryKey.getStoreid());
        verify(inventoryKey, times(1)).getStoreid();
    }

}