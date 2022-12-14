package com.sapient.oms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.oms.entity.Customer;
import com.sapient.oms.repositories.CustomerRepository;

@Service
public class CustomerService implements ICustomerService{
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer save(Customer entity) {
        return customerRepository.save(entity);
    }

    @Override
    public List<Customer> getValue() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findByCustomerName(String name) {
        return customerRepository.findByCustomerName(name).get(0);
    }

}
