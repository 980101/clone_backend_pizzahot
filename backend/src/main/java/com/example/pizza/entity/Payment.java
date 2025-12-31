package com.example.pizza.entity;

import jakarta.persistence.*;

@Entity
public class Payment {
	@Id @GeneratedValue
	private Long id;
	
	@OneToOne
	private Order order;
	
	private int amount;
	
	//@Enumerated(EnumType.STRING)
	//private PaymentStatus status;	// PENDING, CONFIRMED
}
