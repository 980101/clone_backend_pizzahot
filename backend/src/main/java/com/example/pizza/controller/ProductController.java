package com.example.pizza.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pizza.entity.Product;
import com.example.pizza.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

	private final ProductRepository productRepository;
	
	public ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	// 전체 조회
	@GetMapping(produces = "application/json; charset=UTF-8")
	public List<Product> findAll() {
		return productRepository.findAll();
	}
}