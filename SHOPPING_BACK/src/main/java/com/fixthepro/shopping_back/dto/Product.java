package com.fixthepro.shopping_back.dto;

import java.util.UUID;

public class Product {
	
	private String code;
	
	public Product() {
		this.code= UUID.randomUUID().toString().substring(26).toUpperCase();
	}

}
