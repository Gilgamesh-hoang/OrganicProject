package com.laptrinhweb.dto;

public class CategoryBlogDto extends AbstractDto<CategoryBlogDto> {
	private String categoryName;
	private String categoryCode;
	private int numberBlog;

	public int getNumberBlog() {
		return numberBlog;
	}

	public void setNumberBlog(int numberBlog) {
		this.numberBlog = numberBlog;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

}
