package com.sapient.oms.services;

import java.util.List;

import com.sapient.oms.entity.Customer;

public interface ICustomerService {
    List<Customer> getValue();
    Customer save(Customer customer);
    void delete(Integer id);
}
