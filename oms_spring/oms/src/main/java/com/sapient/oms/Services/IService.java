package com.sapient.oms.services;

import java.util.List;

public interface IService<T> {
    void save(T entity);
    List<T> getValue();
}
