package com.laptrinhweb.controller.client;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhweb.service.ICartService;

@Controller
public class CartController extends BaseController {

	@Autowired
	private ICartService cartService;

	@RequestMapping("/gio-hang")
	public ModelAndView cart() {
		mvShare.addObject("cart", cartService.getCart());
		mvShare.setViewName("/client/cart");
		return mvShare;

	}

	@RequestMapping("/gio-hang/them")
	public String addProduct(@RequestParam("productId") Integer productId, HttpServletRequest request,
			@RequestParam(value = "quantity", defaultValue = "1", required = false) Integer quantity) {
		cartService.addProductToCart(productId, quantity);
		return "redirect:" + request.getHeader("Referer");// chuc nang: tra lai trang phia truoc no
	}

	@RequestMapping("/gio-hang/cap-nhat")
	public String updateCart(@RequestParam("id") Integer cartItemId, HttpServletRequest request,
			@RequestParam("quantity") Integer quantity) {
		cartService.updateQuantityInCart(cartItemId, quantity);
		return "redirect:" + request.getHeader("Referer");// chuc nang: tra lai trang phia truoc no
	}

	@RequestMapping("/gio-hang/xoa/{id}")
	public String deleteCart(@PathVariable("id") Integer cartItemId, HttpServletRequest request) {
		cartService.deleteCartItem(cartItemId);
		return "redirect:" + request.getHeader("Referer");// chuc nang: tra lai trang phia truoc no
	}
}
