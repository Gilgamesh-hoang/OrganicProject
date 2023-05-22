package com.laptrinhweb.mapper;

import org.springframework.stereotype.Component;

import com.laptrinhweb.dto.CartDto;
import com.laptrinhweb.entity.CartEntity;

@Component
public class CartMapper extends GeneralMapper<CartDto, CartEntity> {

}
//@Component
//public class CartMapper {
//	@Autowired
//	private ModelMapper modelMapper;
//
//	public CartDto toDTO(CartEntity entities) {
//		return modelMapper.map(entities, CartDto.class);
//	}
//}
