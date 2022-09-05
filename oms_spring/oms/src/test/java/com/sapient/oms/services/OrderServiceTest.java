package com.sapient.oms.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sapient.oms.entity.Order;
import com.sapient.oms.enums.ORDER_STATUS;
import com.sapient.oms.exception.OrderNotFoundException;
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
        expectedOrder.setOrderId(10);
        expectedOrder.setPrice(4000);
        expectedOrder.setOrderStatus(ORDER_STATUS.PLACED);
    }

    @Test
    void testSaveOrder() {
        Order order = new Order(10,4000, ORDER_STATUS.PLACED);
        when(orderRepository.save(any(Order.class))).thenReturn(order);
        Order actualOrder = orderService.save(order);
        assertEquals(expectedOrder, actualOrder);
    }

    @Test
    void testFindOrderByIdExists() {
        Order order = new Order(10,4000, ORDER_STATUS.PLACED);
        Optional<Order> order1 = Optional.of(order);
        when(orderRepository.findById(10)).thenReturn(order1);
        Order actualProduct = orderService.findById(10);
        assertEquals(expectedOrder, actualProduct);
    }

    @Test
    void testFindOrderByIdDoesNotExist() {
        Optional<Order> order = Optional.empty();
        when(orderRepository.findById(10)).thenReturn(order);
        assertThrows(OrderNotFoundException.class,() -> orderService.findById(10));
    }

    @Test
    void testFindOrderByOrderStatusExists() {
        Order order = new Order(10, 4000, ORDER_STATUS.PLACED);
        List<Order> order1 = new ArrayList<>();
        order1.add(order);
        when(orderRepository.findAll()).thenReturn(order1);
        List<Order> actualorder = orderService.findByOrderStatus(ORDER_STATUS.PLACED);
        assertEquals(order1, actualorder);
    }
}
