package com.example.pizza.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.pizza.entity.Cart;
import com.example.pizza.repository.CartRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartService {
	
	private final CartRepository cartRepository;
	
	@Transactional
	public Cart getOrCreateCart(String deviceId) {
		return cartRepository.findByDeviceId(deviceId)
                .orElseGet(() -> {
                    Cart cart = new Cart(deviceId);
                    return cartRepository.save(cart);
                });
	}
}
