package com.laptrinhweb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ManufacturerDto extends AbstractDto<ManufacturerDto> {
	private String manufacturerName;
	private String image;
	private String description;
	private int numberProduct;

}
