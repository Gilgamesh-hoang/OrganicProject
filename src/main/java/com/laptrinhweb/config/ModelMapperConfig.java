package com.laptrinhweb.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
	@Bean
	public ModelMapper modelMapper() {
		// Tạo object và cấu hình
		ModelMapper modelMapper = new ModelMapper();
		// dùng để cấu hình cách mapping
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		// bỏ qua các trường có giá trị null, nghĩa là trường nào null thì không cần
		// mapping

//		modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());

//		 Bỏ qua các giá trị null khi mapping
//		modelMapper.getConfiguration().setSkipNullEnabled(true);

		// Cấu hình để mapping các thuộc tính có tên khác nhau
//        modelMapper.createTypeMap(UserEntity.class, UserDto.class)
//            .addMapping(UserEntity::getFullName, UserDto::setName);

		// Cấu hình để sử dụng Converter, để chuyển đổi một chuỗi thành một đối tượng
		// Date.
//        modelMapper.addConverter(new StringToDateConverter());

		return modelMapper;
	}
}
