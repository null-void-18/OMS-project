package com.sapient.oms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.oms.dto.AddCartDto;
import com.sapient.oms.ecxeptions.CustomException;
import com.sapient.oms.entity.Cart;
import com.sapient.oms.entity.CartItem;
import com.sapient.oms.entity.User;
import com.sapient.oms.repository.CartItemRepository;
import com.sapient.oms.repository.CartRepository;

@Service
public class CartService implements ICartService {
    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    UserService iUserService;

    @Autowired
    CartItemService cartItemService;

    @Autowired
    InventoryService inventoryService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Cart addToCart(AddCartDto cart) {
        Cart newCart = new Cart();
        User user = iUserService.getUserById(cart.getUserid());
        if (user != null) {
            newCart.setStoreId(cart.getStoreId());
            newCart.setUser(user);
        }
        Cart savedCart = cartRepository.save(newCart);
        return savedCart;

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Cart getCart(Integer id) {
        Cart savedCart = cartRepository.findById(id).get();

        return savedCart;

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public CartItem addCartItem(Integer cartid, CartItem cartItem) {
        Cart existingCart = getCart(cartid);
        int productId = cartItem.getProduct().getId();
        if (existingCart == null) {
            throw new CustomException("Cart Not Found");
        }
        if (existingCart.getStoreId() == 0) {
            existingCart.setStoreId(inventoryService.getStoreIdFromInventory(productId));
        }
        if (existingCart.getStoreId() != inventoryService.getStoreIdFromInventory(productId)) {
            throw new CustomException("This product is from different store");
        }
        if (inventoryService.returnQuantity(productId) < cartItem.getQuantity()) {
            throw new CustomException("Out of Stock");

        }
        CartItem savedCartItem = cartItemService.addCartItem(cartItem);
        List<CartItem> existingCartItems = existingCart.getCartItems();
        existingCartItems.add(savedCartItem);
        cartRepository.save(existingCart);
        return savedCartItem;

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public CartItem updateCartItem(Integer cartItemId, Integer quantity) {

        CartItem existingCartItem = cartItemService.findById(cartItemId);
        existingCartItem.setQuantity(quantity);
        CartItem updatedCartItem = cartItemService.addCartItem(existingCartItem);

        return updatedCartItem;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeFromCart(Integer cartId, Integer cartItemId) {

        Cart existingCart = getCart(cartId);

        if (existingCart.getCartItems().size() == 1) {
            existingCart.setStoreId(0);
        }

        cartItemService.deleteById(cartItemId);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Cart deleteCart(Integer cartId) {
        Cart existingCart = getCart(cartId);
        List<CartItem> cartItems = existingCart.getCartItems();

        if (existingCart.getCartItems().isEmpty()) {
            throw new CustomException("Cart is already empty");

        }
        cartItems.forEach((item) -> {
            removeFromCart(cartId, item.getId());
        });
        existingCart.setStoreId(0);
        Cart updatedCart = cartRepository.save(existingCart);
        return updatedCart;
    }

}
