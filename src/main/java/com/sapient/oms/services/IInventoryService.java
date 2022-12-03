package com.sapient.oms.services;

import java.util.List;

import com.sapient.oms.entity.Inventory;

public interface IInventoryService {
    String updateQuantity(Integer storeId,Integer productId,int quantity);

    List<Inventory> findAll();

    List<Inventory> findByStoreId(Integer storeId);
}
