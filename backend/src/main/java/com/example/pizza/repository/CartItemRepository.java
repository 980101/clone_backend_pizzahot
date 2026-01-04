package com.example.pizza.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pizza.entity.Cart;
import com.example.pizza.entity.CartItem;
import com.example.pizza.entity.Product;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
	Optional<CartItem> findByCartAndProduct(Cart cart, Product product);
}
