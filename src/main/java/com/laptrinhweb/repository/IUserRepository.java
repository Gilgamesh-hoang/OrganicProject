package com.laptrinhweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhweb.entity.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity, Integer> {

	UserEntity findOneByUserNameAndActive(String userName, short active);

	UserEntity findOneByUserNameAndEmail(String userName, String email);

	UserEntity findOneByIdAndVerifyCode(int id, String verifyCode);
//	@Query("UPDATE UserEntity SET active = 1 WHERE id=:id AND verifyCode=:verifyCode")
//	UserEntity verifyUser(@Param("id") int id, @Param("verifyCode") String verifyCode);
//	@Modifying
//	@Query("UPDATE UserEntity SET active = 1 WHERE id=:id AND verifyCode=:verifyCode")
//	void verifyUser(@Param("id") int id, @Param("verifyCode") String verifyCode);

	UserEntity findOneByUserName(String userName);

}
