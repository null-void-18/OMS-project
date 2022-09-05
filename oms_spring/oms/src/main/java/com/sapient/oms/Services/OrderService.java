package com.sapient.oms.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.oms.entity.Order;
import com.sapient.oms.entity.OrderItem;
import com.sapient.oms.entity.Product;
import com.sapient.oms.enums.ORDER_STATUS;
import com.sapient.oms.exception.OrderNotFoundException;
import com.sapient.oms.repositories.OrderRepository;

@Service
public class OrderService implements IOrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductService productService;

    @Override
    public void delete(Integer id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<Order> getValue() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> findByOrderStatus(ORDER_STATUS orderStatus) {
        List<Order> allOrders = orderRepository.findAll();
        List<Order> orders = new ArrayList<>();
        for (Order order : allOrders) {
            if (order.getOrderStatus() == orderStatus) {
                orders.add(order);
            }
        }
        return orders;
    }

    @Override
    public Order findById(Integer id) throws OrderNotFoundException {
        Order order = orderRepository.findById(id).orElse(null);
        if (order == null) {
            throw new OrderNotFoundException("Order id=" + id + " not found");
        }
        return order;
    }

    @Override
    public Order save(Order order) {
        Order newOrder = new Order(order);
        newOrder.getOrderitems().addAll((order.getOrderitems().stream().map(orders -> {
            Product product = productService.findById(orders.getProduct().getProductId());
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(product);
            orderItem.setOrder(newOrder);
            orderItem.setQuantity(orders.getQuantity());
            orderItem.setPrice((int)product.getCost());
            return orderItem;
        }).collect(Collectors.toList())));

        return orderRepository.save(newOrder);
    }


}
