package com.sapient.oms.services;

import java.util.List;

public interface IService<T> {
    int save(T entity);
    List<T> getValue();
}
