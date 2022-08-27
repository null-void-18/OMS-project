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

import com.sapient.oms.entity.Order;
import com.sapient.oms.repositories.OrderRepository;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {
    @Mock
    OrderRepository orderRepository;

    @InjectMocks
    OrderService orderService;

    private Order expectedOrder;

    @BeforeEach
    void setup() {
        expectedOrder = new Order();
        expectedOrder.setId(10);
        expectedOrder.setPrice(4000);
    }

    @Test
    void testSaveOrder() {
        Order order = new Order(10,4000);
        when(orderRepository.save(any(Order.class))).thenReturn(order);
        Order actualOrder = orderService.save(order);
        assertEquals(expectedOrder, actualOrder);
    }
}
