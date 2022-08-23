package com.sapient.oms.Services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import com.sapient.oms.Entity.Store;
import com.sapient.oms.Repositories.StoreRepository;


@Service
public class StoreService implements IService<Store> {
    @Autowired
    StoreRepository storeRepository;

    @Override
    public void save(Store store) {
        storeRepository.save(store);
        
    }

    @Override
    public List<Store> getValue() {
        return storeRepository.findAll();
    }

    public void delete(Integer id) {
        storeRepository.deleteById(id);
    }

}
