package com.laptrinhweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhweb.entity.CartEntity;
import com.laptrinhweb.entity.CartItemEntity;
import com.laptrinhweb.entity.ProductEntity;

public interface ICartItemRepository extends JpaRepository<CartItemEntity, Integer> {
	CartItemEntity findByProductAndCart(ProductEntity product, CartEntity cart);

	List<CartItemEntity> findByCart(CartEntity cart);
}
