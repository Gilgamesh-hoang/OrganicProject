package com.laptrinhweb.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto extends AbstractDto<UserDto> {
	private String email;
	private String password;
	private String confirmPassword;
	private String userName;
	private String fullName;
	private String phoneNumber;
	private String address;
	private String verifyCode;
	private List<AddressDto> listAddress = new ArrayList<>();;
	private short active;
	private List<RoleDto> roles = new ArrayList<>();;

}
