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

import com.laptrinhweb.dto.ProductDto;
import com.laptrinhweb.service.IProductService;
import com.laptrinhweb.util.MessageUtil;

@Controller(value = "homeControllerOfAdmin")
public class HomController {
	@Autowired
	private IProductService productService;
	@Autowired
	private MessageUtil messageUtil;

	@RequestMapping("/admin/trang-chu")
	public ModelAndView index(@RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		int limit = 16;
		ProductDto productDto = new ProductDto();
		Pageable pageable = new PageRequest(page - 1, limit);
		int totalPage = (int) Math.ceil((double) productService.getTotalProduct() / limit);
		productDto.setListObject(productService.getAllProduct(pageable));
		productDto.setTotalPage(totalPage);
		productDto.setPage(page);
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mv.addObject("message", message.get("message"));
			mv.addObject("alert", message.get("alert"));
		}
		mv.setViewName("/admin/product");
		mv.addObject("product", productDto);
		return mv;
	}

}
