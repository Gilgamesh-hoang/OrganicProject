package com.laptrinhweb.mapper;

import org.springframework.stereotype.Component;

import com.laptrinhweb.dto.AddressDto;
import com.laptrinhweb.entity.AddressEntity;

@Component
public class AddressMapper extends GeneralMapper<AddressDto, AddressEntity> {

	public void updateData(AddressEntity oldData, AddressDto newData) {
		oldData.setFullName(newData.getFullName());
		oldData.setEmail(newData.getEmail());
		oldData.setAddress(newData.getAddress());
		oldData.setPhoneNumber(newData.getPhoneNumber());
	}

}
