package com.example.pizza.dto;

import com.example.pizza.entity.CartItem;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CartItemResponse {
	private Long cartItemId;
	private Long cartId;
	private Long productId;
	private int quantity;

	public static CartItemResponse from(CartItem cartItem) {
		return new CartItemResponse (
			cartItem.getId(),
			cartItem.getCart().getId(),
			cartItem.getProduct().getId(),
			cartItem.getQuantity()
		);
	}
}
