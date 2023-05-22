package com.laptrinhweb.controller.client;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhweb.service.IWishListService;

@Controller
public class WishListController extends BaseController {
	@Autowired
	private IWishListService wishListService;

	@RequestMapping("/danh-sach-yeu-thich")
	public ModelAndView whistListPage() {
		mvShare.addObject("wishlist", wishListService.getWishList());
		mvShare.setViewName("/client/wishlist");
		return mvShare;
	}

	@RequestMapping("/danh-sach-yeu-thich/them")
	public String addWishList(@RequestParam("productId") Integer productId, HttpServletRequest request) {
		wishListService.addWishList(productId);
		return "redirect:" + request.getHeader("Referer");
	}

	@RequestMapping("/danh-sach-yeu-thich/xoa/{wishlistItemId}")
	public String deleteWishList(@PathVariable("wishlistItemId") Integer wishlistItemId, HttpServletRequest request) {
		wishListService.deleteWishListItem(wishlistItemId);
		return "redirect:" + request.getHeader("Referer");
	}
}
