package com.laptrinhweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.laptrinhweb.entity.ProductEntity;
import com.laptrinhweb.entity.WishListEntity;
import com.laptrinhweb.entity.WishListProductEntity;

public interface IWishListProductRepository extends JpaRepository<WishListProductEntity, Integer> {
	WishListProductEntity findOneByProductAndWishList(ProductEntity product, WishListEntity wishList);

	@Modifying
	@Query("DELETE FROM WishListProductEntity w WHERE w.id = :itemId")
	void deleteItemByItemId(@Param("itemId") int itemId);
}
