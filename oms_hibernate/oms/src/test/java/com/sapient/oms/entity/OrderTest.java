package com.sapient.oms.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sapient.oms.enums.OrderStatus;

@ExtendWith(MockitoExtension.class)
class OrderTest {

    @Mock
    Order order;

    static Order checkOrder=new Order();

    @BeforeAll
    static void setup(){
        checkOrder.setId(1);
        checkOrder.setCreatedDate(new Date());
        checkOrder.setTotalPrice((double) 100000);
        checkOrder.setUser(null);
        checkOrder.setOrderItems(null);
        checkOrder.setStore(null);
        checkOrder.setOrderStatus(OrderStatus.CANCELLED);
    }

    @Test
    void testGetOrderId() {
        when(order.getId()).thenReturn(checkOrder.getId());
        assertEquals(checkOrder.getId(), order.getId());
        verify(order, times(1)).getId();
    }

    @Test
    void testGetOrderUser() {
        when(order.getUser()).thenReturn(checkOrder.getUser());
        assertEquals(checkOrder.getUser(), order.getUser());
        verify(order, times(1)).getUser();
    }

    @Test
    void testGetOrderStore() {
        when(order.getStore()).thenReturn(checkOrder.getStore());
        assertEquals(checkOrder.getStore(), order.getStore());
        verify(order, times(1)).getStore();
    }

    @Test
    void testGetOrderCreatedDate() {
        when(order.getCreatedDate()).thenReturn(checkOrder.getCreatedDate());
        assertEquals(checkOrder.getCreatedDate(), order.getCreatedDate());
        verify(order, times(1)).getCreatedDate();
    }
    @Test
    void testGetOrderItems() {
        when(order.getOrderItems()).thenReturn(checkOrder.getOrderItems());
        assertEquals(checkOrder.getOrderItems(), order.getOrderItems());
        verify(order, times(1)).getOrderItems();
    }
    @Test
    void testGetOrderPrice() {
        when(order.getTotalPrice()).thenReturn(checkOrder.getTotalPrice());
        assertEquals(checkOrder.getTotalPrice(), order.getTotalPrice());
        verify(order, times(1)).getTotalPrice();
    }
    @Test
    void testGetOrderStatus() {
        when(order.getOrderStatus()).thenReturn(checkOrder.getOrderStatus());
        assertEquals(checkOrder.getOrderStatus(), order.getOrderStatus());
        verify(order, times(1)).getOrderStatus();
    }

}