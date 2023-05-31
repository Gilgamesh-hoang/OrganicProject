package com.laptrinhweb.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.laptrinhweb.dto.AddressDto;
import com.laptrinhweb.dto.MyUser;
import com.laptrinhweb.dto.UserDto;

public class SecurityUtils {

	public static MyUser getPrincipal() {
		MyUser user = null;
		if (SecurityContextHolder.getContext().getAuthentication() != null) {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (principal instanceof MyUser) {
				user = (MyUser) principal;
			}
		}
		return user;
	}

	// lay ra roleCode trong GrantedAuthority
	@SuppressWarnings("unchecked")
	public static List<String> getAuthorities() {
		List<String> results = new ArrayList<>();
		List<GrantedAuthority> authorities = (List<GrantedAuthority>) (SecurityContextHolder.getContext()
				.getAuthentication().getAuthorities());
		for (GrantedAuthority authority : authorities) {
			results.add(authority.getAuthority());
		}
		return results;
	}

	// thay đổi thông tin tài khoản
	public static void updatePrincipal(UserDto updatedUser) {
		MyUser user = null;
		if (getPrincipal() != null) {
			user = getPrincipal();
			user.setFullName(updatedUser.getFullName());
			user.setPhoneNumber(updatedUser.getPhoneNumber());
			user.setEmail(updatedUser.getEmail());
		}
	}

	// thay đổi địa chỉ
	public static void updateAddress(AddressDto address) {
		MyUser user = null;
		if (getPrincipal() != null) {
			user = getPrincipal();
			user.setAddress(address);
		}
	}

}
