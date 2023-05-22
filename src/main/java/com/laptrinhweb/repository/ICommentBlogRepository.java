package com.laptrinhweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhweb.entity.CommentBlogEntity;

public interface ICommentBlogRepository extends JpaRepository<CommentBlogEntity, Integer> {

}
