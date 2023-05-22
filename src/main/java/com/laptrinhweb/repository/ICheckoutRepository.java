package com.laptrinhweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laptrinhweb.entity.OrderEntity;
import com.laptrinhweb.entity.UserEntity;

@Repository
public interface ICheckoutRepository extends JpaRepository<OrderEntity, Integer> {
	List<OrderEntity> findByUserOrder(UserEntity userEntity);
}
