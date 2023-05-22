package com.laptrinhweb.controller.client;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhweb.dto.BlogDto;
import com.laptrinhweb.service.IBlogService;
import com.laptrinhweb.service.ICategoryBlogService;
import com.laptrinhweb.util.RelativeURL;

@Controller
public class BlogController extends BaseController {
	@Autowired
	private IBlogService blogService;

	@Autowired
	private ICategoryBlogService categoryBlogService;

	@Autowired
	private RelativeURL url;

	int limit = 6;
	BlogDto blogDto = new BlogDto();

	@RequestMapping(value = "/blog", method = RequestMethod.GET)
	public ModelAndView blog(HttpServletRequest request,
			@RequestParam(value = "categoryId", required = false, defaultValue = "0") Integer categoryId,
			@RequestParam(value = "page", required = false, defaultValue = "1") Integer page) {

		int totalBlog = 0;
		Pageable pageable = new PageRequest(page - 1, limit);
		blogDto.setPage(page);
		// nếu categoryId == 0 có nghĩa là người dùng nhấn vào lọc "tất cả blog "
		if (categoryId == 0) {
			totalBlog = blogService.countAllBlog();
			// lấy ra danh sách các blog đã lọc kèm theo phân trang
			blogDto.setListObject(blogService.getAllBlog(pageable));
		} else {
			totalBlog = blogService.countBlogByCategoryId(categoryId);
			blogDto.setListObject(blogService.getByCategoryId(categoryId, pageable));
		}
		// tính tổng số page có được
		int totalPage = (int) Math.ceil((double) totalBlog / limit);
		blogDto.setTotalPage(totalPage);
		mvShare.addObject("url", url.relativeUrl(request));
		mvShare.addObject("blogs", blogDto);
		addCommonObjectsToModelAndView("/client/blog");
		return mvShare;
	}

	@RequestMapping(value = "/blogDetail/{id}", method = RequestMethod.GET)
	public ModelAndView blogDetail(@PathVariable("id") Integer id) {
		mvShare.addObject("blogMayLike", blogService.blogMayLike(id));
		mvShare.addObject("blog", blogService.getBlogById(id));
		addCommonObjectsToModelAndView("/client/blogDetail");
		return mvShare;
	}

	@RequestMapping(value = "/tim-kiem-blog")
	public ModelAndView searchBlog(@RequestParam("keyword") String keyword, HttpServletRequest request,
			@RequestParam(value = "page", required = false, defaultValue = "1") Integer page) {
		Pageable pageable = new PageRequest(page - 1, limit);
		int totalPage = (int) Math.ceil((double) blogService.countByKeyword(keyword) / limit);
		blogDto.setTotalPage(totalPage);
		blogDto.setPage(page);
		// lấy ra danh sách blog dựa theo keyword
		blogDto.setListObject(blogService.searchBlog(keyword, pageable));
		mvShare.addObject("blogs", blogDto);
		mvShare.addObject("url", url.relativeUrl(request));
		mvShare.addObject("keyword", keyword);
		addCommonObjectsToModelAndView("/client/blog");
		return mvShare;
	}

	private void addCommonObjectsToModelAndView(String viewName) {
		mvShare.addObject("categoryBlog", categoryBlogService.getAllCategoryBlog());
		mvShare.addObject("countAllBlog", blogService.countAllBlog());
		mvShare.addObject("newBlog", blogService.topNewBlog());
		mvShare.setViewName(viewName);
	}

}
