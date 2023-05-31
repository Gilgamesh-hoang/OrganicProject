package com.laptrinhweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhweb.dto.AddressDto;
import com.laptrinhweb.dto.MyUser;
import com.laptrinhweb.entity.AddressEntity;
import com.laptrinhweb.entity.UserEntity;
import com.laptrinhweb.mapper.AddressMapper;
import com.laptrinhweb.repository.IAddressRepository;
import com.laptrinhweb.repository.IUserRepository;
import com.laptrinhweb.service.IAddressService;
import com.laptrinhweb.util.SecurityUtils;

@Service
@Transactional
public class AddressService implements IAddressService {
	@Autowired
	private IAddressRepository addressRepository;
	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private AddressMapper addressMapper;

	@Override
	public List<AddressDto> getAll() {
		MyUser myUser = SecurityUtils.getPrincipal();
		UserEntity userEntity = userRepository.findOne(myUser.getId());
		List<AddressEntity> listEntities = addressRepository.findAllByUser(userEntity);
		return addressMapper.toDTO(listEntities, AddressDto.class);
	}

	@Override
	public AddressDto getById(int id) {
		AddressEntity addressEntity = addressRepository.findOne(id);
		return addressMapper.toDTO(addressEntity, AddressDto.class);
	}

	@Override
	public AddressDto addAndUpdateAddress(AddressDto address) {
		AddressEntity addressEntity;
		// thêm
		if (address.getId() == 0) {
			MyUser myUser = SecurityUtils.getPrincipal();
			UserEntity userEntity = userRepository.findOne(myUser.getId());
			addressEntity = addressMapper.toEntity(address, AddressEntity.class);
			addressEntity.setUser(userEntity);
		} else {// sửa
			addressEntity = addressRepository.findOne(address.getId());
			addressMapper.updateData(addressEntity, address);
		}
		addressEntity = addressRepository.save(addressEntity);
		return addressMapper.toDTO(addressEntity, AddressDto.class);

	}

	@Override
	public void deleteAddress(int addressId) {
		addressRepository.delete(addressId);
	}

	@Override
	public void makeDefaultAddress(int addressId) {
		MyUser myUser = SecurityUtils.getPrincipal();
		AddressEntity newAddress = addressRepository.findOne(addressId);
		AddressEntity oldAddress = addressRepository.findOneByDefaultAddressAndUserId(true, myUser.getId());
		boolean addressChanged = false;
		if (oldAddress == null) {
			newAddress.setDefaultAddress(true);
			addressChanged = true;
		} else if (newAddress.getId() != oldAddress.getId()) {
			newAddress.setDefaultAddress(true);
			oldAddress.setDefaultAddress(false);
			addressChanged = true;
		}
		if (addressChanged && oldAddress != null) {
			newAddress = addressRepository.save(newAddress);
			oldAddress = addressRepository.save(oldAddress);
			// cập nhật lại địa chỉ trong MyUser
			SecurityUtils.updateAddress(addressMapper.toDTO(newAddress, AddressDto.class));
		}
	}

}
