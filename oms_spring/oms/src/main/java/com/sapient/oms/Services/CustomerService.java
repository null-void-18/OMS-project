package com.sapient.oms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.oms.entity.Customer;
import com.sapient.oms.repositories.CustomerRepository;

@Service
public class CustomerService implements IService<Customer> {
    @Autowired
    CustomerRepository customerRepository;

    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void save(Customer entity) {
        customerRepository.save(entity);
    }

    @Override
    public List<Customer> getValue() {
        return customerRepository.findAll();
    }

}
