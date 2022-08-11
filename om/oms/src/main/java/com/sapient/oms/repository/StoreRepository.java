package com.sapient.oms.repository;

import java.util.HashMap;
import java.util.List;

import com.sapient.oms.entity.Store;

public class StoreRepository {
    private HashMap<String,Store> store;

    public StoreRepository() {
        this.store = new HashMap<String, Store>();
    }

    public StoreRepository(HashMap<String, Store> storeDB) {
        this.store = storeDB;
        
    }

    public Store findStore(String storeID) {
        if (store.containsKey(storeID))
            return store.get(storeID);
        return null;
    }

    public List<Store> getAllStores() {
        if (store == null || store.isEmpty())
            return null;
        return store.values().stream().toList();
    }
}
