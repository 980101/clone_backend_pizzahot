package com.example.pizza.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.pizza.entity.Cart;
import com.example.pizza.entity.CartItem;
import com.example.pizza.entity.Product;
import com.example.pizza.repository.CartItemRepository;
import com.example.pizza.repository.CartRepository;
import com.example.pizza.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartService {
	
	private final CartRepository cartRepository;
	private final CartItemRepository cartItemRepository;
	private final ProductRepository productRepository;
	
	@Transactional
	public Cart selectCart(Long deviceId) {
		return cartRepository.findByDeviceId(deviceId)
                .orElseGet(() -> cartRepository.save(new Cart(deviceId))
		);
	}
	
	@Transactional
	public Cart addItem(Long deviceId, Long productId, int quantity) {
		Cart cart = cartRepository.findByDeviceId(deviceId)
				.orElseGet(() -> cartRepository.save(new Cart(deviceId)));
		
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new IllegalArgumentException("상품없음"));
		
		CartItem cartItem = cartItemRepository.findByCartAndProduct(cart, product)
				.orElseGet(() -> {
					CartItem item = new CartItem(cart, product, 0);
					cart.addItem(item);
					return cartItemRepository.save(item);
				});
		
		cartItem.setQuantity(cartItem.getQuantity() + quantity);
		
		return cart;
	}
}
