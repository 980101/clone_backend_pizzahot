package com.example.pizza.entity;

import jakarta.persistence.*;

@Entity
public class Cart {
	@Id @GeneratedValue
	private Long id;
	
	private String deviceId;
}
