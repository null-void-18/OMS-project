package com.sapient.oms.Services;

import java.util.List;

public interface IService<T> {
    void save(T entity);
    List<T> getValue();
}
