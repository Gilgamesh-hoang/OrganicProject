package com.laptrinhweb.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.laptrinhweb.service.ICommentService;

@Controller(value = "commentControllerOfAdmin")
public class CommentController {
	@Autowired
	ICommentService commentService;

	@RequestMapping("/admin/binh-luan/san-pham/xoa")
	public String removeComment(@RequestParam("commentId") Integer commentId, HttpServletRequest request) {
		commentService.removeCommentProduct(commentId);
		return "redirect:" + request.getHeader("Referer");
	}

}
