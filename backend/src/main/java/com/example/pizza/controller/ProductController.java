package com.example.pizza.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pizza.entity.Product;
import com.example.pizza.repository.ProductRepository;

@RestController
@RequestMapping("/api/v1/products")
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
	
	// id로 조회
	@GetMapping(path = "/{id}", produces = "application/json; charset=UTF-8")
	public Product findById(@PathVariable String id) {
		Long productId = Long.parseLong(id);
		return productRepository.getById(productId);
	}
}