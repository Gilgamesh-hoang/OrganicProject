package com.laptrinhweb.service;

import java.util.List;

import com.laptrinhweb.dto.AddressDto;

public interface IAddressService {

	List<AddressDto> getAll();

	AddressDto getById(int id);

	AddressDto addAndUpdateAddress(AddressDto address);

	void deleteAddress(int addressId);

	void makeDefaultAddress(int addressId);
}
