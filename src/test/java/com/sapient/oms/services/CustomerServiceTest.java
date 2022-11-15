package com.sapient.oms.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sapient.oms.entity.Customer;
import com.sapient.oms.repositories.CustomerRepository;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    CustomerService customerService;

    private Customer expectedCustomer;

    @BeforeEach
    void setup() {
        expectedCustomer = new Customer();
        expectedCustomer.setCustomerId(10);
        expectedCustomer.setCustomerName("xxx");
        expectedCustomer.setEmail("abc@gmail.com");
        expectedCustomer.setPassword("*****");
    }

    @Test
    void testSaveCustomer() {
        Customer customer = new Customer(10, "xxx", "*****", "abc@gmail.com");
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);
        Customer actualCustomer = customerService.save(customer);
        assertEquals(expectedCustomer, actualCustomer);
    }
}
