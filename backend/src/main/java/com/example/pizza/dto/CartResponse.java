package com.example.pizza.dto;

import java.util.List;

import com.example.pizza.entity.Cart;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CartResponse {
	
	private Long cartId;
	private Long deviceId;
	private List<CartItemResponse> items;
	
	public static CartResponse from(Cart cart) {
		return new CartResponse(
			cart.getId(),
			cart.getDeviceId(),
			cart.getItems().stream()
				.map(CartItemResponse::from)
				.toList()
		);
	}
}