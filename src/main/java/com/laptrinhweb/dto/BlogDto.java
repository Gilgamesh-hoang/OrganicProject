package com.laptrinhweb.dto;

import java.util.List;

public class BlogDto extends AbstractDto<BlogDto> {

	private String title;
	private String image;
	private String content;
	private String shortDescription;
	private List<CommentBlogDto> listComment;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<CommentBlogDto> getListComment() {
		return listComment;
	}

	public void setListComment(List<CommentBlogDto> listComment) {
		this.listComment = listComment;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

}
