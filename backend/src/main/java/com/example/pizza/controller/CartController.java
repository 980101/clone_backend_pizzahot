package com.example.pizza.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pizza.dto.CartResponse;
import com.example.pizza.entity.Cart;
import com.example.pizza.service.CartService;

@RestController
@RequestMapping("/api/v1/carts")
public class CartController {

	private final CartService cartService;
	
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}
	
	// 조회. 없으면 Cart 자동 생성해서 반환
	@GetMapping()
	public CartResponse findById(@RequestParam String deviceId) {
		Cart cart = cartService.selectCart(deviceId);
		return CartResponse.from(cart);
	}
	
	// 추가. 있으면 덮어쓰기
	@PostMapping
	public CartResponse createCart(@RequestParam String deviceId, @RequestParam int quantity) {
		Cart cart = cartService.insertCart(deviceId, quantity);
		return CartResponse.from(cart);
	}	
}
