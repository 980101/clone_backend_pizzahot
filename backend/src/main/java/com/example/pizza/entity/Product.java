package com.example.pizza.entity;

import jakarta.persistence.*;

@Entity
public class Product {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	private int price;

	protected Product() {}	// JPA 필수
	
	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
    public Long getId() { return id; }
    public String getName() { return name; }
    public int getPrice() { return price; }
}
