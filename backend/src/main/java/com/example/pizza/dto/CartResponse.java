package com.example.pizza.dto;

import com.example.pizza.entity.Cart;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CartResponse {
	
	private Long cartId;
	private String deviceId;
	private int quantity;
	
	public static CartResponse from(Cart cart) {
		return new CartResponse(
				cart.getId(),
				cart.getDeviceId(),
				cart.getQuantity()
			);
	}
}