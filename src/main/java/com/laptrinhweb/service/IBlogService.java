package com.laptrinhweb.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.laptrinhweb.dto.BlogDto;

public interface IBlogService {

	List<BlogDto> getAllBlog(Pageable pageable);

	List<BlogDto> getByCategoryId(int categoryId, Pageable pageable);

	boolean save(BlogDto blogDto);

	boolean delete(int[] ids);

	int countAllBlog();

	int countBlogByCategoryId(int categoryId);

	int countByKeyword(String keyword);

	BlogDto getBlogById(int id);

	List<BlogDto> topNewBlog();

	List<BlogDto> blogMayLike(int blogId);

	List<BlogDto> blogRandom();

	List<BlogDto> searchBlog(String keyword, Pageable pageable);

}
