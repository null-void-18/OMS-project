package com.sapient.oms.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.oms.dto.InventoryDto;
import com.sapient.oms.entity.Inventory;
import com.sapient.oms.entity.Product;
import com.sapient.oms.entity.Store;

import com.sapient.oms.repository.InventoryRepository;

@Service
public class InventoryService implements IInventoryService {
  @Autowired
  InventoryRepository inventoryRepository;
  @Autowired
  IStoreService storeService;

  @Override
  @Transactional(rollbackFor = Exception.class)
  public String addProductToStore(int id, Product product) {
    Store store = storeService.getStoreById(id);
    if (store == null) {
      return "Store Not found";
    }
    Inventory inventory = new Inventory(store, product, 0);
    Inventory savedInventory = inventoryRepository.save(inventory);
    return "Inventory:" + savedInventory;
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public Inventory updateProductToAdd(InventoryDto inventory) {

    Inventory existingInventory = inventoryRepository.findInventory(inventory.getStoreId(), inventory.getProductId());
    int existingCount = existingInventory.getCount();
    existingInventory.setCount(existingCount + inventory.getCount());
    Inventory savedInventory = inventoryRepository.save(existingInventory);

    return savedInventory;

  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public Inventory updateProductToRemove(InventoryDto inventory) {

    Inventory existingInventory = inventoryRepository.findInventory(inventory.getStoreId(), inventory.getProductId());
    int existingCount = existingInventory.getCount();
    existingInventory.setCount(existingCount - inventory.getCount());
    Inventory savedInventory = inventoryRepository.save(existingInventory);

    return savedInventory;

  }

  @Transactional(rollbackFor = Exception.class)
  @Override
  public List<Product> getItems() {
    List<Inventory> inventories = inventoryRepository.findAll();
    List<Product> items = new ArrayList<>();

    inventories.forEach((e) -> {
      items.add(e.getProduct());
    });
    return items;
  }

  @Transactional(rollbackFor = Exception.class)
  @Override
  public List<Product> getProduct(Integer storeId) {
    List<Inventory> savediInventory = inventoryRepository.find(storeId);
    List<Product> products = new ArrayList<>();
    savediInventory.forEach((e) -> {
      products.add(e.getProduct());
    });
    return products;

  }

  @Transactional(rollbackFor = Exception.class)
  @Override
  public int getStoreIdFromInventory(int productId) {
    Inventory returnedInventory = inventoryRepository.findByProduct(productId);
    return returnedInventory.getStore().getId();
  }

  @Transactional(rollbackFor = Exception.class)
  @Override
  public void removeProductFromInventory(Integer productid) {
    inventoryRepository.deleteByProduct(productid);

  }

  @Transactional(rollbackFor = Exception.class)
  @Override
  public int returnQuantity(Integer productId) {
    Inventory inventory = inventoryRepository.findByProduct(productId);
    return inventory.getCount();
  }

}












