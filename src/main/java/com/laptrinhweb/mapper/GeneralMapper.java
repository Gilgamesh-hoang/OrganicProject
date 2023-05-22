package com.laptrinhweb.mapper;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GeneralMapper<D, E> {
	/**
	 * D: DTO; E: Entity
	 */
	@Autowired
	private ModelMapper modelMapper;

	@SuppressWarnings("unchecked")
	public List<D> toDTO(List<E> entities) {
		// In this approach, getClass().getGenericSuperclass() is used to obtain the
		// generic superclass of the implementing class (i.e., GeneralMapper<D, E>), and
		// then getActualTypeArguments()[0] retrieves the actual type argument D (the
		// DTO class) at index 0
		List<D> result = new ArrayList<>();
		for (E entity : entities) {
			// Get the generic type arguments of the GeneralMapper class
			ParameterizedType genericType = (ParameterizedType) getClass().getGenericSuperclass();
			Class<D> dtoClass = (Class<D>) genericType.getActualTypeArguments()[0];
			D dto = modelMapper.map(entity, dtoClass);
			result.add(dto);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public D toDTO(E entity) {
		ParameterizedType genericType = (ParameterizedType) getClass().getGenericSuperclass();
		Class<D> dtoClass = (Class<D>) genericType.getActualTypeArguments()[0];
		D dto = modelMapper.map(entity, dtoClass);
		return dto;
	}

	public E toEntity(D dto, Class<E> entityClass) {
		E entity = modelMapper.map(dto, entityClass);
		return entity;
	}

}
