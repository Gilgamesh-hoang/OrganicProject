package com.laptrinhweb.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhweb.dto.ProductDto;
import com.laptrinhweb.service.IBlogService;
import com.laptrinhweb.service.IProductService;

@Controller
public class HomeController extends BaseController {
	@Autowired
	private IProductService productService;
	@Autowired
	private IBlogService blogService;

	@RequestMapping(value = { "/", "/trang-chu" })
	public ModelAndView index(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page) {

		int limit = 16;
		ProductDto productDto = new ProductDto();
		Pageable pageable = new PageRequest(page - 1, limit);
		int totalPage = (int) Math.ceil((double) productService.getTotalProduct() / limit);
		productDto.setTotalPage(totalPage);
		productDto.setPage(page);
		productDto.setListObject(productService.getAllProduct(pageable));
		mvShare.addObject("products", productDto);
		mvShare.addObject("blog", blogService.blogRandom());
		mvShare.setViewName("/client/home");
		return mvShare;
	}
}
