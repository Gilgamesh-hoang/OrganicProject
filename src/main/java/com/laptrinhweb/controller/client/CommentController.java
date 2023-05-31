package com.laptrinhweb.controller.client;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.laptrinhweb.service.ICommentService;

@Controller
public class CommentController {
	@Autowired
	private ICommentService commentService;

	@RequestMapping(value = "/binh-luan/blog", method = RequestMethod.POST)
	public String commentBlog(@RequestParam("blogId") Integer blogId, @RequestParam("comment") String comment,
			HttpServletRequest request) {
		commentService.commentBlog(blogId, comment);
		return "redirect:" + request.getHeader("Referer");
	}

	@RequestMapping(value = "/binh-luan/san-pham", method = RequestMethod.POST)
	public String commentProduct(@RequestParam("productId") Integer productId, @RequestParam("rate") Short rate,
			@RequestParam("comment") String comment, HttpServletRequest request) {
		commentService.commentProduct(productId, rate, comment);
		return "redirect:" + request.getHeader("Referer");
	}
}
