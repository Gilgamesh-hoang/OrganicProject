package com.laptrinhweb.controller.login;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.laptrinhweb.controller.client.BaseController;
import com.laptrinhweb.dto.MyUser;
import com.laptrinhweb.dto.UserSocial;
import com.laptrinhweb.mapper.UserMapper;
import com.laptrinhweb.service.IUserService;
import com.laptrinhweb.util.FaceBookUtil;
import com.laptrinhweb.util.GoogleUtils;

@Controller
public class LoginSocialController extends BaseController {
	@Autowired
	private GoogleUtils googleUtils;
	@Autowired
	private IUserService userService;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private FaceBookUtil restFB;

	@RequestMapping("/login-google")
	public String loginGoogle(HttpServletRequest request) throws ClientProtocolException, IOException {
		String code = request.getParameter("code");
		if (code == null || code.isEmpty()) {
			return "redirect:dang-nhap?incorrectAccount";
		}
		String accessToken = googleUtils.getToken(code);
		UserSocial userSocial = googleUtils.getUserInfo(accessToken);
		MyUser userDetail = googleUtils.buildUser(userSocial);
		// nếu chưa có user trong databse thì tạo mới
		MyUser myUser = userService.getUserByUserName(userDetail.getUsername());
		if (myUser == null) {
			userService.createAccount(userMapper.toDTO(userDetail));
		} else {
			// load user lên
			userDetail = myUser;
		}
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail, null,
				userDetail.getAuthorities());
		authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		return "redirect:trang-chu";
	}

	/**
	 * Lấy code mà facebook gửi về sau đó đổi code sang access token. Sử dụng
	 * accesstoken lấy thông tin user (có thể thực hiện lưu lại thông tin vào
	 * database để quản lý). Chuyển thông tin user sang đối tượng UserDetails để
	 * spring security quản lý. Sử dụng đối tượng UserDetails trên giống như thông
	 * tin authentication (tương đương với đăng nhập bằng username/password)
	 */
	@RequestMapping("/login-facebook")
	public String loginFacebook(HttpServletRequest request) {
		String code = request.getParameter("code");
		String accessToken = "";
		try {
			accessToken = restFB.getToken(code);
		} catch (IOException e) {
			return "redirect:dang-nhap?incorrectAccount";
		}
		com.restfb.types.User user = restFB.getUserInfo(accessToken);
		MyUser userDetail = restFB.buildUser(user);
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail, null,
				userDetail.getAuthorities());
		authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return "redirect:trang-chu";
	}

}
