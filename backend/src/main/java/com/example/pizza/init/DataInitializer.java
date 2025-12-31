package com.example.pizza.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.pizza.entity.Product;
import com.example.pizza.repository.ProductRepository;

@Component
public class DataInitializer implements CommandLineRunner {
	
	private final ProductRepository productRepository;
	
	public DataInitializer (ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		// 이미 데이터가 있으면 중복 삽입 방지
		if (productRepository.count() > 0) return;
		
		productRepository.save(new Product("페퍼로니 피자", 15000));
		productRepository.save(new Product("치즈 피자", 13000));
		productRepository.save(new Product("파인애플 피자", 17000));
	}
}
