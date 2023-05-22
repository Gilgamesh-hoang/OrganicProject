package com.laptrinhweb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhweb.constant.SystemConstant;
import com.laptrinhweb.dto.MyUser;
import com.laptrinhweb.dto.UserDto;
import com.laptrinhweb.entity.AddressEntity;
import com.laptrinhweb.entity.RoleEntity;
import com.laptrinhweb.entity.UserEntity;
import com.laptrinhweb.mapper.UserMapper;
import com.laptrinhweb.repository.IAddressRepository;
import com.laptrinhweb.repository.IRoleRepository;
import com.laptrinhweb.repository.IUserRepository;
import com.laptrinhweb.service.IUserService;
import com.laptrinhweb.util.SecurityUtils;

@Service
@Transactional
public class UserService implements IUserService {
	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private IRoleRepository roleRepository;
	@Autowired
	private IAddressRepository addressRepository;
	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDto createAccount(UserDto userDto) {
		if (userRepository.findOneByUserName(userDto.getUserName()) != null) {
			return null;
		} else {
			boolean loginWithSocial = false;
			if (userDto.getPassword() == "" || userDto.getPassword() == null) {
				// trường hợp này có nghĩa là người dùng đăng nhập bằng gg hoặc fb
				String password = UUID.randomUUID().toString();
				userDto.setPassword(password);
				userDto.setUserName(userDto.getEmail());
				loginWithSocial = true;
			}
			// mã hóa mật khẩu
			String passwordEncode = encoder.encode(userDto.getPassword());
			UserEntity result = userMapper.toEntity(userDto);
			// set danh sách các role cho user
			List<RoleEntity> roles = new ArrayList<>();
			roles.add(roleRepository.findOneByName(SystemConstant.USER));
			result.setRoles(roles);
			result.setActive(SystemConstant.ACTIVE);
			result.setPassword(passwordEncode);
			result = userRepository.save(result);
			// khi tạo account, đồng thời tạo luôn address mặc định cho user
			if (loginWithSocial == false) {
				AddressEntity addressEntity = new AddressEntity();
				addressEntity.setFullName(result.getFullName());
				addressEntity.setAddress(userDto.getAddress());
				addressEntity.setEmail(result.getEmail());
				addressEntity.setPhoneNumber(result.getPhoneNumber());
				addressEntity.setUser(result);
				addressEntity.setDefaultAddress(true);
				addressRepository.save(addressEntity);
			}

			return userMapper.toDTO(result);
		}
	}

	@Override
	public UserDto editProfile(UserDto userInput) {
		// userInput chỉ chứa các thông tin như fullname, address, phone, email
		// Lấy ra người dùng đang đăng nhập
		MyUser currentUser = SecurityUtils.getPrincipal();

		// Cập nhật thông tin người dùng trong database
		UserEntity oldUser = userRepository.findOne(currentUser.getId());
		oldUser = userMapper.mapInfor(userInput, oldUser);
		UserEntity result = userRepository.save(oldUser);
		// sau khi cập nhật db xong thì cập nhật user trong SecurityContext
		UserDto updatedUser = userMapper.toDTO(result);
		SecurityUtils.updatePrincipal(updatedUser);
		return updatedUser;
	}

	@Override
	public UserDto changePassword(String oldPassword, String newPassword) {
		MyUser currentUser = SecurityUtils.getPrincipal();
		UserEntity user = userRepository.findOne(currentUser.getId());
		// Kiểm tra xem mật khẩu cũ nhập vào có đúng với mật khẩu của người dùng hiện
		// tại hay không
		if (!encoder.matches(oldPassword, user.getPassword())) {
			return null;
		}

		// Mã hóa mật khẩu mới
		String encodedPassword = encoder.encode(newPassword);

		// Cập nhật mật khẩu mới cho người dùng trong cơ sở dữ liệu
		user.setPassword(encodedPassword);
		user = userRepository.save(user);

		// Trả về đối tượng UserDto để thông báo cho người dùng rằng thay đổi mật khẩu
		// đã thành công
		return userMapper.toDTO(user);

	}

	@Override
	public MyUser getUserByUserName(String userName) {
		UserEntity user = userRepository.findOneByUserName(userName);
		if (user == null)
			return null;
		return userMapper.entityToMyUser(user);
	}

}
