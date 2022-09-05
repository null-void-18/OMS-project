package com.sapient.oms.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sapient.oms.entity.Order;
import com.sapient.oms.entity.OrderItem;
import com.sapient.oms.entity.OrderItemId;
import com.sapient.oms.entity.Product;
import com.sapient.oms.exception.StoreNotFoundException;
import com.sapient.oms.repositories.OrderItemRepository;

@ExtendWith(MockitoExtension.class)
public class OrderItemServiceTest {
    @Mock
    OrderItemRepository orderItemRepository;

    @Mock
    OrderService orderService;

    @InjectMocks
    OrderItemService orderItemService;

    private OrderItem orderItem;

    @BeforeEach
    void setup() {
        orderItem = new OrderItem();
        orderItem.setId(new OrderItemId());
        orderItem.setProduct(new Product());
        orderItem.setOrder(new Order());;
    }

    @Test
    void testFindByOrderIdExists() {
        OrderItem inventory = new OrderItem();
        inventory.setId(new OrderItemId());
        inventory.setProduct(new Product());
        inventory.setOrder(new Order());;
        List<OrderItem> inventories = new ArrayList<OrderItem>();
        inventories.add(inventory);
        when(orderService.findById(anyInt())).thenReturn(new Order());
        when(orderItemRepository.findByIdOrderId(anyInt())).thenReturn(inventories);
        List<OrderItem> actualInventory = orderItemService.findByOrderId(100);
        List<OrderItem> expectedResult = new ArrayList<OrderItem>();
        expectedResult.add(orderItem);
        assertEquals(expectedResult,actualInventory);
    }

    @Test
    void testFindByOrderIdDoesNotExist() {
        when(orderService.findById(anyInt())).thenThrow(new StoreNotFoundException(""));
        assertThrows(StoreNotFoundException.class, () -> orderItemService.findByOrderId(100));
    }

    @Test
    void testFindAll() {
        OrderItem inventory = new OrderItem();
        inventory.setId(new OrderItemId());
        inventory.setProduct(new Product());
        inventory.setOrder(new Order());;
        List<OrderItem> inventories = new ArrayList<OrderItem>();
        inventories.add(inventory);
        when(orderItemRepository.findAll()).thenReturn(inventories);
        List<OrderItem> actualInventory = orderItemService.findAll();
        List<OrderItem> expectedResult = new ArrayList<OrderItem>();
        expectedResult.add(orderItem);
        assertEquals(expectedResult,actualInventory);
    }
}
