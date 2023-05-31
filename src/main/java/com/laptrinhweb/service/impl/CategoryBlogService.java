package com.laptrinhweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhweb.dto.CategoryBlogDto;
import com.laptrinhweb.entity.CategoryBlogEntity;
import com.laptrinhweb.mapper.CategoryBlogMapper;
import com.laptrinhweb.repository.ICategoryBlogRepository;
import com.laptrinhweb.service.ICategoryBlogService;

@Service
public class CategoryBlogService implements ICategoryBlogService {
	@Autowired
	private ICategoryBlogRepository categoryBlogRepository;

	@Autowired
	private CategoryBlogMapper categoryBlogMapper;

	@Override
	public List<CategoryBlogDto> getAllCategoryBlog() {
		List<CategoryBlogEntity> entities = categoryBlogRepository.getBlogCountByCategory();
		return categoryBlogMapper.toDTO(entities, CategoryBlogDto.class);
	}

}
