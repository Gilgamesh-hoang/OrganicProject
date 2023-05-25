package com.laptrinhweb.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
	private int id;
	private String email;
	private String fullName;
	private String phoneNumber;
	private String address;
	private boolean defaultAddress;
	private Date modifiedDate;
	private Date createdDate;

}
