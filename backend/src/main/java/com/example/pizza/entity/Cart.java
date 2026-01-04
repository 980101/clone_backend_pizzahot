package com.example.pizza.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Cart {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique = true)
	private Long deviceId;
	
	@OneToMany(mappedBy = "cart")
	private List<CartItem> items = new ArrayList<>();;
	
	protected Cart() {}
	
	public Cart(Long deviceId) {
		this.deviceId = deviceId;
	}
	
	// cartitem 추가
	public void addItem(CartItem item) {
		items.add(item);
		item.setCart(this);
	}
}
