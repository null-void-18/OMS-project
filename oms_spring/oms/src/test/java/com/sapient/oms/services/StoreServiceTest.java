package com.sapient.oms.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sapient.oms.entity.Inventory;
import com.sapient.oms.entity.Store;
import com.sapient.oms.repositories.StoreRepository;

@ExtendWith(MockitoExtension.class)
public class StoreServiceTest {
    @Mock
    StoreRepository storeRepository;

    @InjectMocks
    StoreService storeService;

    private Store expectedStore;

    @BeforeEach
    void setup() {
        expectedStore = new Store();
        expectedStore.setId(10);
        expectedStore.setShopName("shop");
        expectedStore.setContactNumber(12345);
        expectedStore.setEmailId("abc@gmail.com");
        expectedStore.setInventory(new HashSet<Inventory>());
    }

    @Test
    void testSaveStore() {
        Store store = new Store(10, "shop", 12345, "abc@gmail.com", new HashSet<Inventory>());
        when(storeRepository.save(any(Store.class))).thenReturn(store);
        Store actualStore = storeService.save(store);
        assertEquals(expectedStore, actualStore);
    }  
}
