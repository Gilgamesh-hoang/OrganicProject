package com.laptrinhweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhweb.entity.RoleEntity;

public interface IRoleRepository extends JpaRepository<RoleEntity, Integer> {

	RoleEntity findOneByName(String roleName);

}
