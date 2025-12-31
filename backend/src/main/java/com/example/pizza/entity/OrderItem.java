package com.example.pizza.entity;

import jakarta.persistence.*;

@Entity
public class OrderItem {
	@Id @GeneratedValue
	private Long id;
	
	@ManyToOne
	private Order order;
	
	private String productName;
	private int quantity;
	private int unitPrice;
	private int totalPrice;
}
