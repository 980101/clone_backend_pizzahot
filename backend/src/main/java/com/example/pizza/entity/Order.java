package com.example.pizza.entity;

import jakarta.persistence.*;

@Entity
@Table(name ="orders")
public class Order {
	@Id @GeneratedValue
	private Long id;
	
	private String deviceId;
	private int totalPrice;
	
	//@Enumerated(EnumType.STRING)
	//private OrderStatus status;	// CREATED, PAID
}
