package com.sapient.oms.Services;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.oms.Entity.Store;
import com.sapient.oms.Repositories.StoreRepository;


@Service
public class StoreService implements IStoreService {
    @Autowired
    StoreRepository storeRepository;

    @Override
    public void save(Store store) {
        storeRepository.save(store);
        System.out.println("save from service was called.");
    }

    @Override
    public List<Store> getStore() {
        return storeRepository.findAll();
    }

}
