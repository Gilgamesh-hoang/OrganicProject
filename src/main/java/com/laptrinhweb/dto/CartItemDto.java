package com.laptrinhweb.dto;

import com.laptrinhweb.entity.CartEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDto {

	private int id;
	private ProductDto product;
	private int quantity;
	private CartEntity cart;
	private double totalPrice;

}
