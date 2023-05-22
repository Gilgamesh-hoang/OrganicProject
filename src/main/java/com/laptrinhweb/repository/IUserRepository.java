package com.laptrinhweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhweb.entity.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity, Integer> {

	UserEntity findOneByUserNameAndActive(String userName, short active);

	UserEntity findOneByUserName(String userName);

}
