package com.laptrinhweb.dto;

public class UserSocial {

	private String id;
	private String email;
	private boolean verified_email;
	private String name;
	private String given_name;
	private String family_name;
	private String picture;
	private String locale;
	private String hd;

	public String getLocale() {
		return locale;
	}

	public String getHd() {
		return hd;
	}

	public void setHd(String hd) {
		this.hd = hd;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isVerified_email() {
		return verified_email;
	}

	public void setVerified_email(boolean verified_email) {
		this.verified_email = verified_email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGiven_name() {
		return given_name;
	}

	public void setGiven_name(String given_name) {
		this.given_name = given_name;
	}

	public String getFamily_name() {
		return family_name;
	}

	public void setFamily_name(String family_name) {
		this.family_name = family_name;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

//	private String id;
//	private String email;
//	private String name;
//	private String password;
//	private String given_name;
//	private String family_name;
//	private String fullName;
//	private String phoneNumber;
//	private AddressDto address;
//	private short active;
//
//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public String getFullName() {
//		return fullName;
//	}
//
//	public void setFullName(String fullName) {
//		this.fullName = fullName;
//	}
//
//	public String getPhoneNumber() {
//		return phoneNumber;
//	}
//
//	public void setPhoneNumber(String phoneNumber) {
//		this.phoneNumber = phoneNumber;
//	}
//
//	public AddressDto getAddress() {
//		return address;
//	}
//
//	public void setAddress(AddressDto address) {
//		this.address = address;
//	}
//
//	public short getActive() {
//		return active;
//	}
//
//	public void setActive(short active) {
//		this.active = active;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getGiven_name() {
//		return given_name;
//	}
//
//	public void setGiven_name(String given_name) {
//		this.given_name = given_name;
//	}
//
//	public String getFamily_name() {
//		return family_name;
//	}
//
//	public void setFamily_name(String family_name) {
//		this.family_name = family_name;
//	}
//
//	@Override
//	public String toString() {
//		return "UserSocial [id=" + id + ", email=" + email + ", name=" + name + ", password=" + password
//				+ ", given_name=" + given_name + ", family_name=" + family_name + ", fullName=" + fullName
//				+ ", phoneNumber=" + phoneNumber + ", address=" + address + ", active=" + active + "]";
//	}

}
