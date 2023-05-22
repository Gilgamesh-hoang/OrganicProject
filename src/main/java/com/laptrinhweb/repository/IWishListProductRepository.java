package com.laptrinhweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhweb.entity.ProductEntity;
import com.laptrinhweb.entity.WishListEntity;
import com.laptrinhweb.entity.WishListProductEntity;

public interface IWishListProductRepository extends JpaRepository<WishListProductEntity, Integer> {
	WishListProductEntity findOneByProductAndWishList(ProductEntity product, WishListEntity wishList);
}
