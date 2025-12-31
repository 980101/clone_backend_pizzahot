package com.example.pizza.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pizza.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {}