package com.sapient.oms.services;

import java.util.List;

import com.sapient.oms.dto.InventoryDto;
import com.sapient.oms.entity.Inventory;
import com.sapient.oms.entity.Product;

public interface IInventoryService {
    String addProductToStore(int id, Product product);

    Inventory updateProductToAdd(InventoryDto inventory);

    Inventory updateProductToRemove(InventoryDto inventory);

    List<Product> getItems();

    List<Product> getProduct(Integer storeId);

    int getStoreIdFromInventory(int productId);

    void removeProductFromInventory(Integer productid);

    int returnQuantity(Integer productId);

}
