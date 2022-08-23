package com.sapient.oms.Services;

import java.io.IOException;
import java.util.List;

import com.sapient.oms.Entity.Store;

public interface IStoreService {
    void save(Store store) throws IOException;

    List<Store> getStore();
}
