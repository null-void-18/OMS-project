package com.sapient.oms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.oms.ecxeptions.CustomException;
import com.sapient.oms.entity.CartItem;
import com.sapient.oms.repository.CartItemRepository;

@Service
public class CartItemService implements ICartItemService {

    @Autowired
    CartItemRepository cartItemRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Integer id) {
        cartItemRepository.deleteById(id);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)

    public CartItem findById(Integer id) {
        return cartItemRepository.findById(id).get();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)

    public CartItem addCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)

    public CartItem updateCartItembyUnity(Integer cartItemid, String operator) {
        CartItem existingCartItem = findById(cartItemid);
        int originalQuantity = existingCartItem.getQuantity();
        if (operator.equals("increment")) {
            existingCartItem.setQuantity(++originalQuantity);
        } else if (operator.equals("decrement")) {
            existingCartItem.setQuantity(--originalQuantity);

        } else {
            throw new CustomException("Operator invalid");
        }
        CartItem updatedCartItem = addCartItem(existingCartItem);
        return updatedCartItem;
    }

}