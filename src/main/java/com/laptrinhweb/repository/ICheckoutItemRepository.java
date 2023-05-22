package com.laptrinhweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhweb.entity.OrderItemEntity;

public interface ICheckoutItemRepository extends JpaRepository<OrderItemEntity, Integer> {

}
