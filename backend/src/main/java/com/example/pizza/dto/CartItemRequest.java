package com.example.pizza.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CartItemRequest {
	private Long deviceId;
	private Long productId;
	private int quantity;
}
