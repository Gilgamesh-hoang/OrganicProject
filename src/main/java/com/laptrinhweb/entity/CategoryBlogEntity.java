package com.laptrinhweb.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "category_blog")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryBlogEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int categoryId;

	@Column(name = "category_name")
	private String categoryName;

	@Column(name = "category_code")
	private String categoryCode;

	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<BlogEntity> listBlog;

}
