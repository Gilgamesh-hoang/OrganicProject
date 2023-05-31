package com.laptrinhweb.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.laptrinhweb.dto.ManufacturerDto;
import com.laptrinhweb.entity.ManufacturerEntity;

@Component
public class ManufacturerMapper extends GeneralMapper<ManufacturerDto, ManufacturerEntity> {
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<ManufacturerDto> toDTO(List<ManufacturerEntity> entities, Class<ManufacturerDto> dtoClass) {
		List<ManufacturerDto> result = new ArrayList<>();
		for (ManufacturerEntity entity : entities) {
			ManufacturerDto dto = modelMapper.map(entity, dtoClass);
			dto.setNumberProduct(entity.getListProduct().size());
			result.add(dto);
		}
		return result;

	}

}
