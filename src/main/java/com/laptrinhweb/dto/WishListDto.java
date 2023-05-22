package com.laptrinhweb.dto;

import java.util.List;

public class WishListDto {
	private int id;
	private UserDto user;
	private List<WishListProductDto> products;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public List<WishListProductDto> getProducts() {
		return products;
	}

	public void setProducts(List<WishListProductDto> products) {
		this.products = products;
	}

}
