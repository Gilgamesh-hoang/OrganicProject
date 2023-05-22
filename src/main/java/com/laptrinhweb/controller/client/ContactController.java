package com.laptrinhweb.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhweb.service.IContactService;

@Controller
public class ContactController extends BaseController {
	@Autowired
	private IContactService contactService;

	@RequestMapping(value = "/lien-he", method = RequestMethod.GET)
	public ModelAndView contact() {
		mvShare.setViewName("/client/contact");
		return mvShare;
	}

	@RequestMapping(value = "/lien-he", method = RequestMethod.POST)
	public String send(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("message") String message) {
		contactService.sendFeedback(name, email, message);
		return "redirect:trang-chu";
	}
}
