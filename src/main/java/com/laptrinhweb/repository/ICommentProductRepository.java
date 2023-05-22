package com.laptrinhweb.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.laptrinhweb.entity.CommentProductEntity;
import com.laptrinhweb.entity.ProductEntity;

public interface ICommentProductRepository extends JpaRepository<CommentProductEntity, Integer> {
	@Query(value = "SELECT AVG(rate) FROM comment_product", nativeQuery = true)
	double avgRate();

	Page<CommentProductEntity> findCommentByProduct(ProductEntity product, Pageable pageable);

}
