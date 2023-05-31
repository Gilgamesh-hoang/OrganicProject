package com.laptrinhweb.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhweb.dto.ProductDto;
import com.laptrinhweb.service.IGenreService;
import com.laptrinhweb.service.IManufacturerService;
import com.laptrinhweb.service.IProductService;
import com.laptrinhweb.util.MessageUtil;

@Controller(value = "productControllerOfAdmin")
public class ProductController {
	@Autowired
	IProductService productService;
	@Autowired
	IManufacturerService manufacturerService;
	@Autowired
	IGenreService genreService;
	@Autowired
	private MessageUtil messageUtil;

	@RequestMapping(value = { "/admin/san-pham/them", "/admin/san-pham/cap-nhat" })
	public ModelAndView pageAddProduct(@RequestParam(value = "productId", required = false) Integer productId,
			HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		ProductDto productDto = new ProductDto();
		if (productId != null) {// cập nhật sản phẩm
			productDto = productService.getProductById(productId);
		}
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			view.addObject("message", message.get("message"));
			view.addObject("alert", message.get("alert"));
		}
		view.addObject("manufacturers", manufacturerService.getAllManufacturer());
		view.addObject("genres", genreService.getAllGenre());
		view.addObject("product", productDto);
		view.setViewName("/admin/edit-product");
		return view;
	}
}
