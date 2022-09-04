package com.sapient.oms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.oms.entity.Inventory;
import com.sapient.oms.entity.InventoryId;
import com.sapient.oms.exception.StoreNotFoundException;
import com.sapient.oms.repositories.InventoryRepository;

@Service
public class InventoryService implements IInventoryService {
    @Autowired
    InventoryRepository inventoryRepository;

    @Autowired
    StoreService storeService;

    @Override
    public String updateQuantity(Integer storeId, Integer productId, int quantity) {
        InventoryId inventoryId = new InventoryId(storeId.intValue(), productId.intValue());
        Inventory inventory = inventoryRepository.findById(inventoryId).orElse(null);
        if (inventory == null) {
            return "Product not found in the store";
        }
        inventory.setQuantity(quantity);
        inventoryRepository.save(inventory);
        return "Product updated with quantity " + quantity;
    }

    @Override
    public List<Inventory> findAll() {
        List<Inventory> inventories = inventoryRepository.findAll();
        return inventories;
    }

    @Override
    public List<Inventory> findByStoreId(Integer storeId) throws StoreNotFoundException{
        storeService.findById(storeId);
        List<Inventory> inventories = inventoryRepository.findByIdStoreId(storeId);
        return inventories;
    }
}
