package com.laptrinhweb.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WishListProductDto {
	private int id;
	private WishListDto wishList;
	private ProductDto product;
	private Date addDate;

}
