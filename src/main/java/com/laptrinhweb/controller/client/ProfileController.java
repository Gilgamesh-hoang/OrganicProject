package com.laptrinhweb.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhweb.dto.MyUser;
import com.laptrinhweb.dto.UserDto;
import com.laptrinhweb.mapper.UserMapper;
import com.laptrinhweb.service.ICheckOutService;
import com.laptrinhweb.service.IUserService;
import com.laptrinhweb.service.IWishListService;
import com.laptrinhweb.util.SecurityUtils;

@Controller
public class ProfileController extends BaseController {
	@Autowired
	private IUserService userService;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private ICheckOutService checkOutService;
	@Autowired
	private IWishListService wishListService;

	private MyUser user;

	/** các chức năng chỉnh sửa thông tin của người dùng **/
	@RequestMapping(value = "/thong-tin-tai-khoan")
	public ModelAndView profile() {
		mvShare.setViewName("/client/dashboard");
		user = SecurityUtils.getPrincipal();
		mvShare.addObject("user", user);
		mvShare.addObject("listOrder", checkOutService.getListOrder());
		mvShare.addObject("numberProductLike", wishListService.numberProductLike());
		return mvShare;
	}

	@RequestMapping(value = "/thong-tin-cua-toi")
	public ModelAndView myProfile() {
		mvShare.setViewName("/client/dash-my-profile");
		user = SecurityUtils.getPrincipal();
		mvShare.addObject("user", user);
		mvShare.addObject("listOrder", checkOutService.getListOrder());
		mvShare.addObject("numberProductLike", wishListService.numberProductLike());
		return mvShare;
	}

	@RequestMapping(value = "/chinh-sua-thong-tin", method = RequestMethod.GET)
	public ModelAndView editProfile() {
		mvShare.setViewName("/client/dash-edit-profile");
		user = SecurityUtils.getPrincipal();
		mvShare.addObject("user", userMapper.toDTO(user));
		mvShare.addObject("listOrder", checkOutService.getListOrder());
		mvShare.addObject("numberProductLike", wishListService.numberProductLike());
		return mvShare;
	}

	@RequestMapping(value = "/chinh-sua-thong-tin", method = RequestMethod.POST)
	public String editProfile(@ModelAttribute("user") UserDto userInput) {
		userService.editProfile(userInput);
		return "redirect:thong-tin-cua-toi";
	}

	@RequestMapping(value = "/thay-doi-mat-khau", method = RequestMethod.GET)
	public ModelAndView editPassword() {
		mvShare.setViewName("/client/dash-change-passwd");
		mvShare.addObject("listOrder", checkOutService.getListOrder());
		mvShare.addObject("numberProductLike", wishListService.numberProductLike());
		return mvShare;
	}

	@RequestMapping(value = "/thay-doi-mat-khau", method = RequestMethod.POST)
	public String editPassword(@RequestParam("currentPassword") String currentPassword,
			@RequestParam("newPassword") String newPassword) {
		UserDto userDto = userService.changePassword(currentPassword, newPassword);
		// nếu thay đổi mật khẩu không thành công
		if (userDto == null) {
			return "redirect:thay-doi-mat-khau?error";
		} else {
			return "redirect:thong-tin-cua-toi";
		}
	}

	/** các chức năng quản lý đơn hàng của người dùng **/
	@RequestMapping(value = "/don-hang/{orderId}", method = RequestMethod.GET)
	public ModelAndView orderManagement(@PathVariable("orderId") Integer orderId) {
		user = SecurityUtils.getPrincipal();
		mvShare.setViewName("/client/dash-manage-order");
		mvShare.addObject("user", user);
		mvShare.addObject("listOrder", checkOutService.getListOrder());
		mvShare.addObject("order", checkOutService.getOrderById(orderId));
		mvShare.addObject("numberProductLike", wishListService.numberProductLike());
		return mvShare;
	}
}
