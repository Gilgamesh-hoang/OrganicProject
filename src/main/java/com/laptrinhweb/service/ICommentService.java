package com.laptrinhweb.service;

public interface ICommentService {

	void commentBlog(int blogId, String comment);

	void commentProduct(int productId, short rate, String comment);

}
