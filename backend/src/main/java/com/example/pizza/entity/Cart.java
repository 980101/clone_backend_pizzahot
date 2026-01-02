package com.example.pizza.entity;

import jakarta.persistence.*;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String deviceId;
	
	protected Cart() {}
	
	public Cart(String deviceId) {
		this.deviceId = deviceId;
	}
	
	public Long getId() { return id; }
	public String getDeviceId() { return deviceId;	}
}
