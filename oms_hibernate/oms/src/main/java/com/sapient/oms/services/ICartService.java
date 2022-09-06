package com.sapient.oms.services;

import com.sapient.oms.dto.AddCartDto;
import com.sapient.oms.entity.Cart;
import com.sapient.oms.entity.CartItem;

public interface ICartService {
     Cart addToCart(AddCartDto cart);

     Cart getCart(Integer id);

     CartItem addCartItem(Integer cartId, CartItem cartItem);

     CartItem updateCartItem(Integer cartItemId, Integer quantity);

     void removeFromCart(Integer cartId, Integer cartItemId);

     Cart deleteCart(Integer cartId);

}