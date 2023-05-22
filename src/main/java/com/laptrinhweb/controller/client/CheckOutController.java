package com.laptrinhweb.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhweb.dto.AddressDto;
import com.laptrinhweb.dto.CartDto;
import com.laptrinhweb.dto.MyUser;
import com.laptrinhweb.service.ICartService;
import com.laptrinhweb.service.ICheckOutService;
import com.laptrinhweb.util.SecurityUtils;

@Controller
public class CheckOutController extends BaseController {
	@Autowired
	private ICartService cartService;
	@Autowired
	private ICheckOutService checkOutService;

	@RequestMapping(value = "/thanh-toan", method = RequestMethod.GET)
	public ModelAndView checkOut() {
		MyUser myUser = SecurityUtils.getPrincipal();
		CartDto cart = cartService.getCartCheckout();

		if (cart.getTotalQuantity() == 0) {
			mvShare.setViewName("/client/cart");
			return mvShare;
		} else {
			// myUser.getAddress() == null nếu chưa chọn địa chỉ thì không cho thanh
			// toán(chỗ này sửa code lại sau)
			mvShare.addObject("adrress", (myUser.getAddress() == null) ? new AddressDto() : myUser.getAddress());
			mvShare.addObject("cart", cartService.getCartCheckout());
			mvShare.setViewName("/client/checkout");
			return mvShare;
		}
	}

	@RequestMapping(value = "/thanh-toan", method = RequestMethod.POST)
	public String checkOut(@RequestParam("note") String note) {
		checkOutService.order(note);
		return "redirect:gio-hang";
	}

}
