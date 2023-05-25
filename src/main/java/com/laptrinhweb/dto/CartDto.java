package com.laptrinhweb.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {

	private int cartId;
	private double totalPrice;
	private int totalQuantity;
	private UserDto user;
	private List<CartItemDto> items;

}
