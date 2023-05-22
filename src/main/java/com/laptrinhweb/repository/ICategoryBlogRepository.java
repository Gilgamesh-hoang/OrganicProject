package com.laptrinhweb.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.laptrinhweb.entity.CategoryBlogEntity;

public interface ICategoryBlogRepository extends JpaRepository<CategoryBlogEntity, Integer> {
	@Query("SELECT c FROM CategoryBlogEntity c LEFT JOIN c.listBlog b GROUP BY c ORDER BY COUNT(b) DESC")
	List<Object> countBlogByCategory();

	// lay ra danh sach cac category kem theo so luong blog cua category do
	default List<CategoryBlogEntity> getBlogCountByCategory() {
		List<Object> list = countBlogByCategory();
		List<CategoryBlogEntity> result = new ArrayList<>();
		for (Object entry : list) {
			result.add((CategoryBlogEntity) entry);
		}

		return result;
	}
}
