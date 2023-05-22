package com.laptrinhweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.laptrinhweb.dto.BlogDto;
import com.laptrinhweb.entity.BlogEntity;
import com.laptrinhweb.mapper.BlogMapper;
import com.laptrinhweb.repository.IBlogRepository;
import com.laptrinhweb.service.IBlogService;

@Service
public class BlogService implements IBlogService {
	@Autowired
	private IBlogRepository blogRepository;

	@Autowired
	private BlogMapper blogMapper;

	@Override
	public List<BlogDto> getAllBlog(Pageable pageable) {
		List<BlogEntity> entities = blogRepository.findAll(pageable).getContent();
		return blogMapper.toDTO(entities);
	}

	@Override
	public BlogDto getBlogById(int id) {
		BlogEntity blogEntity = blogRepository.findOne(id);
		return blogMapper.toDTO(blogEntity);
	}

	@Override
	public List<BlogDto> topNewBlog() {
		// lấy ra các blog mới nhất, PageRequest(0, 5) có nghĩa là lấy ra 5 blog đầu
		// tiên
		Pageable pageable = new PageRequest(0, 5);
		List<BlogEntity> topNewBlogs = blogRepository.topNewBlog(pageable);
		return blogMapper.toDTO(topNewBlogs);
	}

	@Override
	public List<BlogDto> blogMayLike(int blogId) {
		// lấy ngẫu nhiên 3 blog, dùng cho blogDetail.jsp
		return blogMapper.toDTO(blogRepository.blogMayLike(blogId));
	}

	@Override
	public int countAllBlog() {
		return (int) blogRepository.count();
	}

	@Override
	public List<BlogDto> getByCategoryId(int categoryId, Pageable pageable) {
		return blogMapper.toDTO(blogRepository.findByCategoryId(categoryId, pageable));
	}

	@Override
	public int countBlogByCategoryId(int categoryId) {
		return blogRepository.countBlogByCategoryId(categoryId);
	}

	@Override
	public int countByKeyword(String keyword) {
		return blogRepository.countByKeyword(keyword);
	}

	@Override
	public List<BlogDto> searchBlog(String keyword, Pageable pageable) {
		return blogMapper.toDTO(blogRepository.searchBlog(keyword, pageable));
	}

	@Override
	public List<BlogDto> blogRandom() {
		return blogMapper.toDTO(blogRepository.blogRandom());
	}

}
