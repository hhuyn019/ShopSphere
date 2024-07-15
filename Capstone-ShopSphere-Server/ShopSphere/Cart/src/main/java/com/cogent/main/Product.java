package com.cogent.main;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
	private int id;	
	private String name;
	private String description;
	private double price;
	private String category;
	private String imageUrl;
	private int quantity;
}