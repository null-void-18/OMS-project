package com.sapient.oms.services;

import java.util.List;

import com.sapient.oms.entity.Store;

public interface IStoreService {
    List<Store> getValue();
    Store save(Store store);
    void delete(Integer id);
}
