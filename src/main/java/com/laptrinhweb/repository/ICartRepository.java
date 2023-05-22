package com.laptrinhweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhweb.entity.CartEntity;

public interface ICartRepository extends JpaRepository<CartEntity, Integer> {
	CartEntity findByUserId(int id);
}
