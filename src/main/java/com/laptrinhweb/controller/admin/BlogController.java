package com.laptrinhweb.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhweb.dto.AddressDto;
import com.laptrinhweb.dto.BlogDto;
import com.laptrinhweb.service.IBlogService;
import com.laptrinhweb.service.ICategoryBlogService;
import com.laptrinhweb.util.MessageUtil;

@Controller(value = "blogControllerOfAdmin")
public class BlogController {
	@Autowired
	IBlogService blogService;
	@Autowired
	private ICategoryBlogService categoryBlogService;
	@Autowired
	private MessageUtil messageUtil;

	@RequestMapping("/admin/blog")
	public ModelAndView index(@RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		int limit = 4;
		BlogDto blogDto = new BlogDto();
		Pageable pageable = new PageRequest(page - 1, limit);
		int totalPage = (int) Math.ceil((double) blogService.countAllBlog() / limit);
		blogDto.setListObject(blogService.getAllBlog(pageable));
		blogDto.setTotalPage(totalPage);
		blogDto.setPage(page);
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mv.addObject("message", message.get("message"));
			mv.addObject("alert", message.get("alert"));
		}
		mv.setViewName("/admin/blog");
		mv.addObject("blog", blogDto);
		return mv;
	}

	@RequestMapping(value = { "/admin/blog/them", "/admin/blog/cap-nhat" })
	public ModelAndView pageAddBlog(@RequestParam(value = "blogId", required = false) Integer blogId,
			HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		BlogDto blogDto = new BlogDto();
		if (blogId != null) {// cập nhật sản phẩm
			blogDto = blogService.getBlogById(blogId);
		}
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			view.addObject("message", message.get("message"));
			view.addObject("alert", message.get("alert"));
		}
		view.addObject("categories", categoryBlogService.getAllCategoryBlog());
		view.addObject("blog", blogDto);
		view.setViewName("/admin/edit-blog");
		AddressDto addressDto = new AddressDto();

		return view;

	}
}
