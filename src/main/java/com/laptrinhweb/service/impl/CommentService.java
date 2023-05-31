package com.laptrinhweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhweb.dto.MyUser;
import com.laptrinhweb.entity.BlogEntity;
import com.laptrinhweb.entity.CommentBlogEntity;
import com.laptrinhweb.entity.CommentProductEntity;
import com.laptrinhweb.entity.ProductEntity;
import com.laptrinhweb.entity.UserEntity;
import com.laptrinhweb.repository.IBlogRepository;
import com.laptrinhweb.repository.ICommentBlogRepository;
import com.laptrinhweb.repository.ICommentProductRepository;
import com.laptrinhweb.repository.IProductRepository;
import com.laptrinhweb.repository.IUserRepository;
import com.laptrinhweb.service.ICommentService;
import com.laptrinhweb.util.SecurityUtils;

@Service
public class CommentService implements ICommentService {
	@Autowired
	private ICommentBlogRepository commentBlogRepository;
	@Autowired
	private ICommentProductRepository commentProductRepository;
	@Autowired
	private IBlogRepository blogRepository;
	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private IProductRepository productRepository;

	@Override
	public void commentBlog(int blogId, String comment) {
		MyUser myUser = SecurityUtils.getPrincipal();
		UserEntity user = userRepository.findOne(myUser.getId());
		BlogEntity blogEntity = blogRepository.findOne(blogId);
		CommentBlogEntity commenEntity = new CommentBlogEntity();
		commenEntity.setBlog(blogEntity);
		commenEntity.setUser(user);
		commenEntity.setContent(comment);
		commentBlogRepository.save(commenEntity);
	}

	@Override
	public void commentProduct(int productId, short rate, String comment) {
		MyUser myUser = SecurityUtils.getPrincipal();
		UserEntity user = userRepository.findOne(myUser.getId());
		ProductEntity productEntity = productRepository.findOne(productId);
		// Update the rate for the product
		productEntity.setRate((short) commentProductRepository.avgRate());
		productRepository.save(productEntity);

		CommentProductEntity commentProduct = new CommentProductEntity();
		commentProduct.setProduct(productEntity);
		commentProduct.setUser(user);
		commentProduct.setRate(rate);
		commentProduct.setContent(comment);
		commentProductRepository.save(commentProduct);
	}

	@Override
	public void removeCommentProduct(int commentId) {
		commentProductRepository.delete(commentId);

	}

}
