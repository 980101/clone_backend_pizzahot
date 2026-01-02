package com.example.pizza.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Cart {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique = true)
	private String deviceId;
	private int quantity;
	
	protected Cart() {}
	
	public Cart(String deviceId, int quantity) {
		this.deviceId = deviceId;
		this.quantity = quantity;
	}
}
