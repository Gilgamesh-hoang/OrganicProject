package com.laptrinhweb.dto;

import java.util.List;

import com.laptrinhweb.entity.ManufacturerEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto extends AbstractDto<ProductDto> {
	private String productName;
	private double price;
	private String image;
	private int available;
	private int sold;
	private double discount;
	private double weight;
	private String description;
	private Short status;
	private GenreDto genre;
	private short rate;
	private ManufacturerEntity manufacturer;
	private List<CommentProductDto> listComment;
	private int totalComment;

}
