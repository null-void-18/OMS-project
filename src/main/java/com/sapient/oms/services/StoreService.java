package com.sapient.oms.services;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.oms.entity.Inventory;
import com.sapient.oms.entity.Product;
import com.sapient.oms.entity.Store;
import com.sapient.oms.exception.StoreNotFoundException;
import com.sapient.oms.repositories.StoreRepository;

@Service
public class StoreService implements IStoreService {
    @Autowired
    StoreRepository storeRepository;

    @Autowired
    ProductService productService;

    @Override
    public Store save(Store store) {
        Store newStore = new Store(store);
        newStore.getInventory().addAll((store.getInventory().stream().map(inventories -> {
            Product product = productService.findById(inventories.getProduct().getProductId());
            Inventory inventory = new Inventory();
            inventory.setProduct(product);
            inventory.setStore(newStore);
            inventory.setQuantity(inventories.getQuantity());
            return inventory;
        }).collect(Collectors.toList())));

        return storeRepository.save(newStore);
    }

    @Override
    public List<Store> getValue() {
        return storeRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        storeRepository.deleteById(id);
    }

    @Override
    public Store findById(Integer storeId) throws StoreNotFoundException{
        Store store = storeRepository.findById(storeId).orElse(null);
        if(store == null) {
            throw new StoreNotFoundException("Store Not Found");
        }
        return store;
    }

    @Override
    public Store addProduct(Integer storeId, Integer productId, Integer quantity) {
        Store store = storeRepository.findById(storeId).orElse(null);
        if (store == null) {
            throw new StoreNotFoundException("Store Not Found");
        }
        Collection<Inventory> inventories = store.getInventory();
        Inventory inventory = new Inventory();
        inventory.setProduct(productService.findById(productId));
        inventory.setStore(store);
        inventory.setQuantity(quantity);
        inventories.add(inventory);
        store.setInventory(inventories);
        return storeRepository.save(store);
    }
}
