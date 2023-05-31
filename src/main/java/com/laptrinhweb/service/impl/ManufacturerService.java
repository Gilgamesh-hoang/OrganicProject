package com.laptrinhweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhweb.dto.ManufacturerDto;
import com.laptrinhweb.entity.ManufacturerEntity;
import com.laptrinhweb.mapper.ManufacturerMapper;
import com.laptrinhweb.repository.IManufacturerRepository;
import com.laptrinhweb.service.IManufacturerService;

@Service
public class ManufacturerService implements IManufacturerService {
	@Autowired
	private IManufacturerRepository manufacturerRepository;

	@Autowired
	private ManufacturerMapper manufacturerMapper;

	@Override
	public List<ManufacturerDto> getAllManufacturer() {
		List<ManufacturerEntity> entities = manufacturerRepository.getProductCountByManufacturer();
		return manufacturerMapper.toDTO(entities, ManufacturerDto.class);
	}

}
