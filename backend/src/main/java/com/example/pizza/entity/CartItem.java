package com.example.pizza.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CartItem {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "cart_id")
	private Cart cart;
	
	private Product product;
	private int quantity;
	
	protected CartItem() {}
	
	public CartItem(Cart cart, Product product, int quantity) {
		this.cart = cart;
		this.product = product;
		this.quantity = quantity;
	}
}
