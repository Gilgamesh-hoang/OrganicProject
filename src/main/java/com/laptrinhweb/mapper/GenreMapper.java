package com.laptrinhweb.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.laptrinhweb.dto.GenreDto;
import com.laptrinhweb.entity.GenreEntity;

@Component
public class GenreMapper extends GeneralMapper<GenreDto, GenreEntity> {
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<GenreDto> toDTO(List<GenreEntity> entities) {
		List<GenreDto> result = new ArrayList<>();
		for (GenreEntity entity : entities) {
			GenreDto dto = modelMapper.map(entity, GenreDto.class);
			dto.setNumberProduct(entity.getListProduct().size());
			result.add(dto);
		}
		return result;
	}

}
