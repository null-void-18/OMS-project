package com.sapient.oms.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sapient.oms.entity.Inventory;
import com.sapient.oms.entity.InventoryId;
import com.sapient.oms.entity.Product;
import com.sapient.oms.entity.Store;
import com.sapient.oms.exception.StoreNotFoundException;
import com.sapient.oms.repositories.InventoryRepository;

@ExtendWith(MockitoExtension.class)
public class InventoryServiceTest {
    @Mock
    InventoryRepository inventoryRepository;

    @Mock
    StoreService storeService;

    @InjectMocks
    InventoryService inventoryService;

    private Inventory expectedInventory;

    @BeforeEach
    void setup() {
        expectedInventory = new Inventory();
        expectedInventory.setId(new InventoryId());
        expectedInventory.setProduct(new Product());
        expectedInventory.setStore(new Store());
    }

    @Test
    void testUpdateQuantitySuccess() {
        Inventory inventory1 = new Inventory();
        Optional<Inventory> inventory = Optional.of(inventory1);
        when(inventoryRepository.save(any(Inventory.class))).thenReturn(inventory1);
        when(inventoryRepository.findById(any(InventoryId.class))).thenReturn(inventory);
        String actualInventory = inventoryService.updateQuantity(1, 1, 100);
        String expectedResult = "Product updated with quantity 100";
        assertEquals(expectedResult,actualInventory);
    }

    @Test
    void testUpdateQuantityFails() {
        Optional<Inventory> inventory = Optional.empty();
        when(inventoryRepository.findById(any(InventoryId.class))).thenReturn(inventory);
        String actualInventory = inventoryService.updateQuantity(1, 1, 100);
        String expectedResult = "Product not found in the store";
        assertEquals(expectedResult,actualInventory);
    }

    @Test
    void testFindByStoreIdExists() {
        Inventory inventory = new Inventory();
        inventory.setId(new InventoryId());
        inventory.setProduct(new Product());
        inventory.setStore(new Store());
        List<Inventory> inventories = new ArrayList<Inventory>();
        inventories.add(inventory);
        when(storeService.findById(anyInt())).thenReturn(new Store());
        when(inventoryRepository.findByIdStoreId(anyInt())).thenReturn(inventories);
        List<Inventory> actualInventory = inventoryService.findByStoreId(100);
        List<Inventory> expectedResult = new ArrayList<Inventory>();
        expectedResult.add(expectedInventory);
        assertEquals(expectedResult,actualInventory);
    }

    @Test
    void testFindByStoreIdDoesNotExist() {
        when(storeService.findById(anyInt())).thenThrow(new StoreNotFoundException(""));
        assertThrows(StoreNotFoundException.class, () -> inventoryService.findByStoreId(100));
    }

    @Test
    void testFindAll() {
        Inventory inventory = new Inventory();
        inventory.setId(new InventoryId());
        inventory.setProduct(new Product());
        inventory.setStore(new Store());
        List<Inventory> inventories = new ArrayList<Inventory>();
        inventories.add(inventory);
        when(inventoryRepository.findAll()).thenReturn(inventories);
        List<Inventory> actualInventory = inventoryService.findAll();
        List<Inventory> expectedResult = new ArrayList<Inventory>();
        expectedResult.add(expectedInventory);
        assertEquals(expectedResult,actualInventory);
    }
}
