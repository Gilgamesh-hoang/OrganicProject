package com.laptrinhweb.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BlogDto extends AbstractDto<BlogDto> {

	private String title;
	private String image;
	private String content;
	private String shortDescription;
	private List<CommentBlogDto> listComment;

}
