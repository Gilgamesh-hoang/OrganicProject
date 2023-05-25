package com.laptrinhweb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryBlogDto extends AbstractDto<CategoryBlogDto> {
	private String categoryName;
	private String categoryCode;
	private int numberBlog;

}
