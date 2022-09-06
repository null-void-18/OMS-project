package com.sapient.oms.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.oms.dto.InventoryDto;
import com.sapient.oms.dto.OrderDto;
import com.sapient.oms.ecxeptions.CustomException;
import com.sapient.oms.entity.Cart;
import com.sapient.oms.entity.CartItem;
import com.sapient.oms.entity.Order;
import com.sapient.oms.entity.OrderItem;
import com.sapient.oms.entity.Store;
import com.sapient.oms.entity.User;
import com.sapient.oms.enums.OrderStatus;
import com.sapient.oms.notification.EmailTemplate;
import com.sapient.oms.repository.OrderRepository;

@Service
public class OrderService implements IOrderService {

    @Autowired
    IUserService iUserService;
    @Autowired
    IStoreService iStoreService;
    @Autowired
    IOrderItemService iOrderItemService;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    IInventoryService inventoryService;
    EmailTemplate emailTemplate = new EmailTemplate();

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Order addOrder(OrderDto order) {

        User user = iUserService.getUserById(order.getUserId());
        Store store = iStoreService.getStoreById(order.getStoreId());
        Cart cart = user.getCart();
        List<CartItem> cartItems = cart.getCartItems();

        if (cartItems.isEmpty()) {
            throw new CustomException("Items cannot be empty");
        }
        Order newOrder = new Order();
        newOrder.setCreatedDate(new Date());
        newOrder.setUser(user);
        newOrder.setStore(store);
        newOrder.setTotalPrice(order.getTotalPrice());
        newOrder.setOrderStatus(OrderStatus.PLACED);
        Order savedOrder = orderRepository.save(newOrder);

        for (CartItem cartItem : cartItems) {
            if (inventoryService.returnQuantity(cartItem.getProduct().getId()) < cartItem.getQuantity()) {
                throw new CustomException("Out of Stock");

            }
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setPrice(cartItem.getProduct().getPrice());
            orderItem.setOrder(savedOrder);
            iOrderItemService.addOrderedProducts(orderItem);

            InventoryDto inventory = new InventoryDto(store.getId(), cartItem.getProduct().getId(),
                    cartItem.getQuantity());
            inventoryService.updateProductToRemove(inventory);
        }
        emailTemplate.mailonOrderCreation(savedOrder);

        return savedOrder;
    }

    @Transactional(rollbackFor = Exception.class)

    @Override
    public Order getOrder(Integer orderid) {
        Order order = orderRepository.findById(orderid).get();
        return order;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<OrderItem> getOrderItems(Integer orderid) {
        Order order = orderRepository.findById(orderid).get();
        List<OrderItem> orderItems = order.getOrderItems();
        return orderItems;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<Order> getOrdersByUserId(Integer userId) {
        User user = iUserService.getUserById(userId);

        return user.getOrders();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<Order> getOrdersByStoreId(Integer storeId) {
        Store store = iStoreService.getStoreById(storeId);

        return store.getOrders();
    }

}
