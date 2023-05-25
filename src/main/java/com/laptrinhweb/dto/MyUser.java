package com.laptrinhweb.dto;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyUser extends User {
	private static final long serialVersionUID = 1L;
	private int id;
	private Date createdDate;
	private Date modifiedDate;
	private String email;
	private String fullName;
	private String phoneNumber;
	private AddressDto address;
	private short active;

	public MyUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}

}
