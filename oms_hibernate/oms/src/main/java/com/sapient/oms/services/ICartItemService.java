package com.sapient.oms.services;

import com.sapient.oms.entity.CartItem;

public interface ICartItemService {
    void deleteById(Integer id);

    CartItem findById(Integer id);

    CartItem addCartItem(CartItem cartItem);

    CartItem updateCartItembyUnity(Integer cartItemid, String operator);

}
