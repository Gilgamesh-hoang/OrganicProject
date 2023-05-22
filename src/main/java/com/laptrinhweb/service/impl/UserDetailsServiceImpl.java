package com.laptrinhweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.laptrinhweb.constant.SystemConstant;
import com.laptrinhweb.entity.UserEntity;
import com.laptrinhweb.mapper.UserMapper;
import com.laptrinhweb.repository.IUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// đầu tiên mình query xuống database xem có user đó không
		UserEntity userEntity = userRepository.findOneByUserNameAndActive(userName, SystemConstant.ACTIVE);

		if (userEntity == null) {
			System.out.println("User not found! " + userName);
			throw new UsernameNotFoundException("User " + userName + " was not found in the database");
		}

		System.out.println("Found User: " + userName);

		// [ROLE_USER, ROLE_ADMIN,..]
		// Dựa vào list quyền trả về mình tạo đối tượng GrantedAuthority của spring cho
		// quyền đó
//		List<GrantedAuthority> authorities = new ArrayList<>();
//		for (RoleEntity role : userEntity.getRoles()) {
//			authorities.add(new SimpleGrantedAuthority(role.getName()));
//		}

		// Cuối cùng mình tạo đối tượng UserDetails của Spring và mình cung cấp các
		// thông số như tên , password và quyền
		// Đối tượng userDetails sẽ chứa đựng các thông tin cần thiết về user từ đó giúp
		// Spring Security quản lý được phân quyền
//		MyUser userDetails = new MyUser(userEntity.getUserName(), userEntity.getPassword(), true, true, true, true,
//				authorities);
//		userDetails.setId(userEntity.getId());
//		userDetails.setFullName(userEntity.getFullName());
//		userDetails.setEmail(userEntity.getEmail());
//		userDetails.setActive(userEntity.getActive());
//		userDetails.setCreatedDate(userEntity.getCreatedDate());
//		userDetails.setModifiedDate(userEntity.getModifiedDate());
//		userDetails.setPhoneNumber(userEntity.getPhoneNumber());
//		for (AddressEntity address : userEntity.getListAddress()) {
//			if (address.isDefaultAddress()) {
//				userDetails.setAddress(addressMapper.toDTO(address));
//				break;
//			}
//		}
//		return userDetails;
		return userMapper.entityToMyUser(userEntity);

	}
}
