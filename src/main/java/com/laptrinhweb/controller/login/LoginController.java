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
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhweb.controller.client.BaseController;
import com.laptrinhweb.dto.UserDto;
import com.laptrinhweb.service.IUserService;

@Controller
public class LoginController extends BaseController {

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
			return "redirect:dang-nhap?success";
		} else {
			return "redirect:dang-ky?accountExisted";
		}
	}

	@RequestMapping(value = "/lost-password", method = RequestMethod.GET)
	public ModelAndView indexLostPassword() {
		mvShare.setViewName("/login/lost-password");
		return mvShare;
	}

	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		return new ModelAndView("redirect:/dang-nhap?accessDenied");
	}
}
