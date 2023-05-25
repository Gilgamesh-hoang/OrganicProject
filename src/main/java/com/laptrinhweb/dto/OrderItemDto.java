package com.laptrinhweb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {
	private int id;
	private ProductDto product;
	private double totalPrice;
	private int quantity;

}
