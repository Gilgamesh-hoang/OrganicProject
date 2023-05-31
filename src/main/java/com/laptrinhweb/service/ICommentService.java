package com.laptrinhweb.service;

public interface ICommentService {

	void removeCommentProduct(int commentId);

	void commentBlog(int blogId, String comment);

	void commentProduct(int productId, short rate, String comment);

}
