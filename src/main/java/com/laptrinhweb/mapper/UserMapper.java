package com.laptrinhweb.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.laptrinhweb.dto.AddressDto;
import com.laptrinhweb.dto.MyUser;
import com.laptrinhweb.dto.UserDto;
import com.laptrinhweb.entity.AddressEntity;
import com.laptrinhweb.entity.RoleEntity;
import com.laptrinhweb.entity.UserEntity;

@Component
public class UserMapper extends GeneralMapper<UserDto, UserEntity> {
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private AddressMapper addressMapper;

	public UserDto toDTO(MyUser myUser) {
		UserDto dto = modelMapper.map(myUser, UserDto.class);
		return dto;
	}

	public UserEntity toEntity(UserDto dto) {
		Date current = new Date();
		dto.setCreatedDate(current);
		dto.setModifiedDate(current);
		return modelMapper.map(dto, UserEntity.class);
	}

	public UserEntity mapInfor(UserDto newUser, UserEntity oldUser) {
		oldUser.setFullName(newUser.getFullName());
		oldUser.setPhoneNumber(newUser.getPhoneNumber());
		oldUser.setEmail(newUser.getEmail());
		return oldUser;
	}

	public MyUser entityToMyUser(UserEntity userEntity) {
		// [ROLE_USER, ROLE_ADMIN,..]
		// Dựa vào list quyền trả về mình tạo đối tượng GrantedAuthority của spring cho
		// quyền đó
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (RoleEntity role : userEntity.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		// Cuối cùng mình tạo đối tượng UserDetails của Spring và mình cung cấp các
		// thông số như tên , password và quyền
		// Đối tượng userDetails sẽ chứa đựng các thông tin cần thiết về user từ đó giúp
		// Spring Security quản lý được phân quyền
		MyUser userDetails = new MyUser(userEntity.getUserName(), userEntity.getPassword(), true, true, true, true,
				authorities);
		userDetails.setId(userEntity.getId());
		userDetails.setFullName(userEntity.getFullName());
		userDetails.setEmail(userEntity.getEmail());
		userDetails.setActive(userEntity.getActive());
		userDetails.setCreatedDate(userEntity.getCreatedDate());
		userDetails.setModifiedDate(userEntity.getModifiedDate());
		userDetails.setPhoneNumber(userEntity.getPhoneNumber());
		for (AddressEntity address : userEntity.getListAddress()) {
			if (address.isDefaultAddress()) {
				userDetails.setAddress(addressMapper.toDTO(address, AddressDto.class));
				break;
			}
		}
		return userDetails;
	}

}
//@Component
//public class UserMapper {
//	@Autowired
//	private ModelMapper modelMapper;
//
//	public UserDto toDTO(UserEntity entity) {
//		return modelMapper.map(entity, UserDto.class);
//	}
//
//	public UserDto toDTO(MyUser myUser) {
//		return modelMapper.map(myUser, UserDto.class);
//	}
//
//	public MyUser toMyUser(UserDto userDto, MyUser user) {
//		user.setFullName(userDto.getFullName());
////		user.setAddress(userDto.getAddress());
//		user.setPhoneNumber(userDto.getPhoneNumber());
//		user.setEmail(userDto.getEmail());
//		return user;
//	}
//
//	public UserEntity toEntity(UserDto dto) {
////		PropertyMap<UserDto, UserEntity> propertyMap = new PropertyMap<>() {
////			/**
////			 * gọi phương thức skip() để chỉ định rằng chúng ta sẽ bỏ qua các trường
////			 * createdDate và modifiedDate khi mapping từ đối tượng UserDto sang UserEntity.
////			 * Sau đó, chúng ta đã thêm đối tượng propertyMap vào ModelMapper để sử dụng khi
////			 * thực hiện mapping từ UserDto sang UserEntity.
////			 */
////			protected void configure() {
////				skip(destination.getCreatedDate());
////				skip(destination.getModifiedDate());
////
////			}
////		};
////		modelMapper.addMappings(propertyMap);
//		Date current = new Date();
//		dto.setCreatedDate(current);
//		dto.setModifiedDate(current);
//		return modelMapper.map(dto, UserEntity.class);
//	}
//
//	public UserEntity mapInfor(UserDto newUser, UserEntity oldUser) {
//		oldUser.setFullName(newUser.getFullName());
//		oldUser.setPhoneNumber(newUser.getPhoneNumber());
//		oldUser.setEmail(newUser.getEmail());
//		return oldUser;
//	}
//
//}
