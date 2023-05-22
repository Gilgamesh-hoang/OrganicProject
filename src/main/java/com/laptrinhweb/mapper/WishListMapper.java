package com.laptrinhweb.mapper;

import org.springframework.stereotype.Component;

import com.laptrinhweb.dto.WishListDto;
import com.laptrinhweb.entity.WishListEntity;

@Component
public class WishListMapper extends GeneralMapper<WishListDto, WishListEntity> {

}
//@Component
//public class WishListMapper {
//	@Autowired
//	private ModelMapper modelMapper;
//
//	public WishListDto toDTO(WishListEntity entities) {
//		return modelMapper.map(entities, WishListDto.class);
//	}
//}
