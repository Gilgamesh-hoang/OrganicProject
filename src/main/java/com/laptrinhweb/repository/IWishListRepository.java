package com.laptrinhweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhweb.entity.WishListEntity;

public interface IWishListRepository extends JpaRepository<WishListEntity, Integer> {
	WishListEntity findOneByUserId(int id);
}
