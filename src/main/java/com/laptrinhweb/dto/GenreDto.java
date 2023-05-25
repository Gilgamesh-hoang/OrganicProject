package com.laptrinhweb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GenreDto extends AbstractDto<GenreDto> {

	private String genreName;
	private String genreCode;
	private short status;
	private int numberProduct;

}
