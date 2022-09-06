package com.sapient.oms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sapient.oms.dto.AddCartDto;
import com.sapient.oms.entity.Cart;
import com.sapient.oms.entity.CartItem;
import com.sapient.oms.services.ICartItemService;
import com.sapient.oms.services.ICartService;

@RestController
@RequestMapping("/oms/cart")
public class CartController {

   @Autowired
   ICartService cartService;

   @Autowired
   ICartItemService cartItemService;

   @PostMapping("/")
   public Cart addToCart(@RequestBody AddCartDto cart) {

      return cartService.addToCart(cart);

   }

   @GetMapping("/{id}")
   public Cart getCartById(@PathVariable("id") Integer id) {

      return cartService.getCart(id);

   }

   @PostMapping("/cartitem/{id}")
   public CartItem addCartItem(@PathVariable("id") Integer cartid, @RequestBody CartItem cartItem) {

      return cartService.addCartItem(cartid, cartItem);

   }

   @PutMapping("/cartitem/{id}")
   public CartItem updateCartItem(@PathVariable("id") Integer cartitemid, @RequestBody ObjectNode json) {
      int quantity = json.get("quantity").asInt();
      return cartService.updateCartItem(cartitemid, quantity);

   }

   @PutMapping("/cartitem/update/{id}")
   public CartItem updateCartItemByUnity(@PathVariable("id") Integer cartitemid, @RequestBody ObjectNode json) {
      String operator = json.get("operator").asText();
      return cartItemService.updateCartItembyUnity(cartitemid, operator);

   }

   @DeleteMapping("/{cartid}/cartitem/{id}")
   public String deleteCartItem(@PathVariable("cartid") Integer cartid, @PathVariable("id") Integer cartItemId) {
      cartService.removeFromCart(cartid, cartItemId);
      return "CartItem has been successfully Removed from cart";

   }

   @DeleteMapping("/{cartid}")
   public Cart deleteCart(@PathVariable("cartid") Integer cartid) {
      return cartService.deleteCart(cartid);

   }
}
