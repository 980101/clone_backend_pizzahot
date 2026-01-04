package com.example.pizza.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pizza.dto.CartItemRequest;
import com.example.pizza.dto.CartResponse;
import com.example.pizza.entity.Cart;
import com.example.pizza.service.CartService;


@RestController
@RequestMapping("/api/v1/cartitems")
public class CartItemController {

	private final CartService cartService;
	
	public CartItemController(CartService cartService) {
		this.cartService = cartService;
	}
	
	@PostMapping
	public CartResponse addCartItemtoCart(@RequestBody CartItemRequest request) {
		Cart cart = cartService.addItem(
			request.getDeviceId(),
			request.getProductId(),
			request.getQuantity()
		);
		return CartResponse.from(cart);
	}
}
