package com.sapient.oms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.oms.entity.Store;
import com.sapient.oms.repository.StoreRepository;

@Service
public class StoreService implements IStoreService {
    @Autowired
    StoreRepository storeRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Store> getAllStores() {
        List<Store> stores = storeRepository.findAll();
        return stores;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Store getStoreById(int id) {
        Store store = storeRepository.findById(id).get();
        return store;
    }
}
