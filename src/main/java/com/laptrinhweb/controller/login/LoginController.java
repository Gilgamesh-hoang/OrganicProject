package com.laptrinhweb.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhweb.controller.client.BaseController;
import com.laptrinhweb.dto.UserDto;
import com.laptrinhweb.service.IUserService;
import com.laptrinhweb.util.MailUtil;

@Controller
public class LoginController extends BaseController {

	@Autowired
	private MailUtil mailUtil;

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public ModelAndView indexLogin() {
		mvShare.setViewName("/login/login");
		return mvShare;
	}

	@RequestMapping(value = "/dang-xuat", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			new SecurityContextLogoutHandler().logout(request, response, authentication);
		}
		return "redirect:trang-chu";
	}

	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	public ModelAndView register() {
		mvShare.addObject("user", new UserDto());
		mvShare.setViewName("/login/register");
		return mvShare;
	}

	@RequestMapping(value = "/dang-ky", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") UserDto userDto) {
		UserDto user = userService.createAccount(userDto);
		if (user != null) {
			mailUtil.sendMailVerifyUser(user);
			return "redirect:dang-nhap?registerSuccess";
		} else {
			return "redirect:dang-ky?accountExisted";
		}
	}

	@RequestMapping(value = "/xac-thuc-nguoi-dung", method = RequestMethod.GET)
	public String verifyUser(@RequestParam("id") Integer userId, @RequestParam("verifyCode") String verifyCode) {
		UserDto user = userService.verifyUser(userId, verifyCode);
		if (user != null) {
			return "redirect:dang-nhap?verifySuccess";
		} else {
			return "redirect:dang-ky?verifyError";
		}
	}

	@RequestMapping(value = "/quen-mat-khau", method = RequestMethod.GET)
	public ModelAndView lostPassword() {
		mvShare.setViewName("/login/lost-password");
		return mvShare;
	}

	@RequestMapping(value = "/quen-mat-khau", method = RequestMethod.POST)
	public String sendPasswordResetEmail(@RequestParam("username") String username,
			@RequestParam("email") String email) {
		UserDto userDto = userService.getUserByEmailAndUserName(email, username);
		if (userDto != null) {
			String newPassword = userService.resetPassword(userDto);
			mailUtil.sendMailResetPassword(userDto, newPassword);
			return "redirect:dang-nhap?resetPasswordSuccess";
		} else {
			return "redirect:quen-mat-khau?incorrect";
		}
	}

	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		return new ModelAndView("redirect:/dang-nhap?accessDenied");
	}
}
