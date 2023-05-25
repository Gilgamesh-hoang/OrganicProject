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
public class CommentProductDto {
	private int id;
	private String content;
	private short rate;
	private UserDto user;
	private ProductDto product;
	private Date createdDate;
	private Date modifiedDate;

}
