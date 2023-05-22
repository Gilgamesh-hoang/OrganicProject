package com.laptrinhweb.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category_blog")
public class CategoryBlogEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int categoryId;

	@Column(name = "category_name")
	private String categoryName;

	@Column(name = "category_code")
	private String categoryCode;

	@OneToMany(mappedBy = "category")
	private List<BlogEntity> listBlog;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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

	public List<BlogEntity> getListBlog() {
		return listBlog;
	}

	public void setListBlog(List<BlogEntity> listBlog) {
		this.listBlog = listBlog;
	}

}
