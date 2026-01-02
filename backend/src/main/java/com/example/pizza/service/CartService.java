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
	public Cart selectCart(String deviceId) {
		return cartRepository.findByDeviceId(deviceId)
                .orElseGet(() -> {
                    Cart cart = new Cart(deviceId, 0);
                    return cartRepository.save(cart);
                });
	}
	
	@Transactional
	public Cart insertCart(String deviceId, int quantity) {
	    Cart cart = cartRepository.findByDeviceId(deviceId)
	            .orElseGet(() -> cartRepository.save(new Cart(deviceId, 0)));

	    cart.setQuantity(cart.getQuantity() + quantity);
	    return cartRepository.save(cart);
	}
}
