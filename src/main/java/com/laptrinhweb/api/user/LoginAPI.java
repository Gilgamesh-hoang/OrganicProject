package com.laptrinhweb.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhweb.dto.ResponseObject;
import com.laptrinhweb.dto.UserDto;
import com.laptrinhweb.service.IUserService;
import com.laptrinhweb.util.MailUtil;

@RestController
@RequestMapping("/api")
public class LoginAPI {
	@Autowired
	private IUserService userService;
	@Autowired
	private MailUtil mailUtil;

	@PostMapping("/dang-ky")
	public ResponseEntity<ResponseObject> registerAccount(@RequestBody UserDto userDto) {
		UserDto user = userService.createAccount(userDto);
		if (user == null)
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
					.body(new ResponseObject("Username already exists"));
		return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseObject("Create user is successfully", user));
	}

	@GetMapping("/xac-thuc-nguoi-dung")
	public ResponseEntity<ResponseObject> verifyUser(@RequestParam("id") Integer userId,
			@RequestParam("verifyCode") String verifyCode) {
		UserDto user = userService.verifyUser(userId, verifyCode);
		if (user != null) {
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("Verify user is successfully", user));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseObject("Verify user is error because userId or verifyCode is not correct"));
		}
	}

	@PostMapping("/quen-mat-khau")
	public ResponseEntity<ResponseObject> sendPasswordResetEmail(@RequestParam("username") String username,
			@RequestParam("email") String email) {
		UserDto userDto = userService.getUserByEmailAndUserName(email, username);
		if (userDto != null) {
			String newPassword = userService.resetPassword(userDto);
//			mailUtil.sendMailResetPassword(userDto, newPassword);
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseObject("Changed password success", newPassword));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
					.body(new ResponseObject("Password change failed because username or email are incorrect"));
		}
	}
}
