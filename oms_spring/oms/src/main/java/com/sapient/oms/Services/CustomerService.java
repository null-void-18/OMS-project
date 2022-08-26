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
    public int save(Customer entity) {
        customerRepository.save(entity);
        return 1;
    }

    @Override
    public List<Customer> getValue() {
        return customerRepository.findAll();
    }

}
