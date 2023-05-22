package com.laptrinhweb.mapper;

import org.springframework.stereotype.Component;

import com.laptrinhweb.dto.ProductDto;
import com.laptrinhweb.entity.ProductEntity;

@Component
public class ProductMapper extends GeneralMapper<ProductDto, ProductEntity> {

}
//@Component
//public class ProductMapper {
//	@Autowired
//	private ModelMapper modelMapper;
//
//	public List<ProductDto> toDTO(List<ProductEntity> entities) {
//		List<ProductDto> result = new ArrayList<>();
//		for (ProductEntity entity : entities) {
//			result.add(modelMapper.map(entity, ProductDto.class));
//		}
//		return result;
//	}
//
//	public ProductDto toDTO(ProductEntity entity) {
//		return modelMapper.map(entity, ProductDto.class);
//	}
//
//}
