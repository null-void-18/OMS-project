package com.sapient.oms.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import com.sapient.oms.entity.Store;
import com.sapient.oms.repositories.StoreRepository;


@Service
public class StoreService implements IService<Store> {
    @Autowired
    StoreRepository storeRepository;

    @Override
    public int save(Store store) {
        storeRepository.save(store);
        return store.getId();
    }

    @Override
    public List<Store> getValue() {
        return storeRepository.findAll();
    }

    public void delete(Integer id) {
        storeRepository.deleteById(id);
    }

}
