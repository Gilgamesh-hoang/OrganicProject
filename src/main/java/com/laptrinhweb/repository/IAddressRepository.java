package com.laptrinhweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhweb.entity.AddressEntity;
import com.laptrinhweb.entity.UserEntity;

public interface IAddressRepository extends JpaRepository<AddressEntity, Integer> {
	List<AddressEntity> findAllByUser(UserEntity userEntity);

	AddressEntity findOneByDefaultAddressAndUserId(boolean defaultAddress, int userId);
}
