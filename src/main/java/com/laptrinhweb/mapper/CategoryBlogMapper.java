package com.laptrinhweb.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.laptrinhweb.dto.CategoryBlogDto;
import com.laptrinhweb.entity.CategoryBlogEntity;

@Component
public class CategoryBlogMapper extends GeneralMapper<CategoryBlogDto, CategoryBlogEntity> {
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<CategoryBlogDto> toDTO(List<CategoryBlogEntity> entities) {
		List<CategoryBlogDto> result = new ArrayList<>();
		for (CategoryBlogEntity entity : entities) {
			CategoryBlogDto dto = modelMapper.map(entity, CategoryBlogDto.class);
			dto.setNumberBlog(entity.getListBlog().size());
			result.add(dto);
		}
		return result;
	}
}
//@Component
//public class CategoryBlogMapper{
//	@Autowired
//	private ModelMapper modelMapper;
//
//	public List<CategoryBlogDto> toDTO(List<CategoryBlogEntity> entities) {
//		List<CategoryBlogDto> result = new ArrayList<>();
//		for (CategoryBlogEntity entity : entities) {
//			CategoryBlogDto dto = modelMapper.map(entity, CategoryBlogDto.class);
//			dto.setNumberBlog(entity.getListBlog().size());
//			result.add(dto);
//		}
//		return result;
//	}
//
//	public CategoryBlogDto toDTO(CategoryBlogEntity entity) {
//		return modelMapper.map(entity, CategoryBlogDto.class);
//	}
//
//}
