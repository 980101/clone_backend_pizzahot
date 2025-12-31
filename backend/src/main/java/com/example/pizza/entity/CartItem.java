package com.example.pizza.entity;

import jakarta.persistence.*;

@Entity
public class CartItem {
	@Id @GeneratedValue
	private Long id;
	
	@ManyToOne
	private Cart cart;
	
	@ManyToOne
	private Product product;
	
	private int quantity;
	private int unitPrice;	// 스냅샷
	private int totalPrice;
}
