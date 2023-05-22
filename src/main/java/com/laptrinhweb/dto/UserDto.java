package com.laptrinhweb.dto;

import java.util.List;

public class UserDto extends AbstractDto<UserDto> {
	private String email;
	private String password;
	private String confirmPassword;
	private String userName;
	private String fullName;
	private String phoneNumber;
	private String address;
	private List<AddressDto> listAddress;
	private short active;
	private List<RoleDto> roles;

	public List<RoleDto> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleDto> roles) {
		this.roles = roles;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public short getActive() {
		return active;
	}

	public List<AddressDto> getListAddress() {
		return listAddress;
	}

	public void setListAddress(List<AddressDto> listAddress) {
		this.listAddress = listAddress;
	}

	public void setActive(short active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "UserDto [email=" + email + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ ", userName=" + userName + ", fullName=" + fullName + ", phoneNumber=" + phoneNumber + ", address="
				+ address + ", listAddress=" + listAddress + ", active=" + active + ", roles=" + roles + "]";
	}

}
