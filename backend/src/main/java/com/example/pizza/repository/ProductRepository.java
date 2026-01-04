package com.example.pizza.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pizza.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	Optional<Product> findById(String productId);
}