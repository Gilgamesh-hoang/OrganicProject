package com.laptrinhweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhweb.dto.GenreDto;
import com.laptrinhweb.entity.GenreEntity;
import com.laptrinhweb.mapper.GenreMapper;
import com.laptrinhweb.repository.IGenreRepository;
import com.laptrinhweb.service.IGenreService;

@Service
public class GenreService implements IGenreService {
	@Autowired
	private IGenreRepository genreRepository;

	@Autowired
	private GenreMapper genreMapper;

	@Override
	public List<GenreDto> getAllGenre() {
		List<GenreEntity> entities = genreRepository.getProductCountByGenre();
		return genreMapper.toDTO(entities, GenreDto.class);
	}

}
