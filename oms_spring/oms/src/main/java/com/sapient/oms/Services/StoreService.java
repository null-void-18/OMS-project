package com.sapient.oms.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.oms.entity.Store;
import com.sapient.oms.repositories.StoreRepository;


@Service
public class StoreService implements IStoreService {
    @Autowired
    StoreRepository storeRepository;

    @Override
    public Store save(Store store) {
        return storeRepository.save(store);
    }

    @Override
    public List<Store> getValue() {
        return storeRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        storeRepository.deleteById(id);
    }

}
