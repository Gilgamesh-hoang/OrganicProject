package com.laptrinhweb.dto;

import java.util.Date;

public class WishListProductDto {
	private int id;
	private WishListDto wishList;
	private ProductDto product;
	private Date addDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public WishListDto getWishList() {
		return wishList;
	}

	public void setWishList(WishListDto wishList) {
		this.wishList = wishList;
	}

	public ProductDto getProduct() {
		return product;
	}

	public void setProduct(ProductDto product) {
		this.product = product;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

}
