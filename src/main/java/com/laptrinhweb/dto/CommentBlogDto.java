package com.laptrinhweb.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentBlogDto {
	private int id;
	private String content;
	private UserDto user;
	private BlogDto blog;
	private Date createdDate;
	private Date modifiedDate;

}
