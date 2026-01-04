package com.example.pizza.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pizza.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
	
	// id 기준 조회
	Optional<Cart> findByDeviceId(Long deviceId);
}
