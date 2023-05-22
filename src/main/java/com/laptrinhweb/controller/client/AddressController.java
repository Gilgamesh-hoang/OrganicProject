package com.laptrinhweb.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhweb.dto.AddressDto;
import com.laptrinhweb.service.IAddressService;

@Controller
public class AddressController extends BaseController {
	@Autowired
	private IAddressService addressService;

	@RequestMapping("/dia-chi")
	public ModelAndView addressBook() {
		mvShare.addObject("listAddress", addressService.getAll());
		mvShare.setViewName("/client/dash-address-book");
		return mvShare;
	}

	@RequestMapping(value = "/dia-chi/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editAddress(@RequestParam(value = "addressId", required = false) Integer addressId) {
		// thêm mới
		if (addressId == null) {
			mvShare.addObject("address", new AddressDto());
		} else {
			// cập nhật
			mvShare.addObject("address", addressService.getById(addressId));
		}
		mvShare.setViewName("/client/dash-address-edit");
		return mvShare;
	}

	@RequestMapping(value = "/dia-chi/xoa", method = RequestMethod.GET)
	public String deleteAddress(@RequestParam(value = "addressId") Integer addressId) {
		addressService.deleteAddress(addressId);
		return "redirect:/dia-chi";
	}

	@RequestMapping(value = "/dia-chi/chinh-sua", method = RequestMethod.POST)
	public String updateAddress(@ModelAttribute("address") AddressDto address) {
		addressService.addAndUpdateAddress(address);
		return "redirect:/dia-chi";
	}

	@RequestMapping("/dia-chi/mac-dinh")
	public ModelAndView defaultAddress() {
		mvShare.addObject("listAddress", addressService.getAll());
		mvShare.setViewName("/client/dash-address-make-default");
		return mvShare;
	}

	@RequestMapping("/dia-chi/mac-dinh/{addressId}")
	public String makeDefaultAddress(@PathVariable("addressId") Integer addressId) {
		addressService.makeDefaultAddress(addressId);
		return "redirect:/dia-chi/mac-dinh";
	}

}
