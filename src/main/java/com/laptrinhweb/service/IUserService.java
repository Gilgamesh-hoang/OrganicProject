package com.laptrinhweb.service;

import com.laptrinhweb.dto.MyUser;
import com.laptrinhweb.dto.UserDto;

public interface IUserService {

	UserDto createAccount(UserDto userDto);

	UserDto editProfile(UserDto userInput);

	UserDto changePassword(String currentPassword, String newPassword);

	MyUser getUserByUserName(String userName);
}