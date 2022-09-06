package com.sapient.oms.services;

import java.util.List;

import com.sapient.oms.entity.Store;

public interface IStoreService {
    public List<Store> getAllStores();

    public Store getStoreById(int id);
}
