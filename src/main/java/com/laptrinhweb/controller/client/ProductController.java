package com.laptrinhweb.controller.client;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhweb.dto.ProductDto;
import com.laptrinhweb.service.ICommentService;
import com.laptrinhweb.service.IGenreService;
import com.laptrinhweb.service.IManufacturerService;
import com.laptrinhweb.service.IProductService;
import com.laptrinhweb.util.RelativeURL;

@Controller
public class ProductController extends BaseController {
	@Autowired
	private IProductService productService;
	@Autowired
	private ICommentService commentService;

	@Autowired
	private IManufacturerService manufacturerService;

	@Autowired
	private IGenreService genreService;

	@Autowired
	private RelativeURL url;

	private int limit = 9;
	private ProductDto productDto = new ProductDto();

	@RequestMapping(value = "/san-pham")
	public ModelAndView getProduct(@RequestParam(value = "id") Integer id, HttpServletRequest request,
			@RequestParam(value = "page", required = false, defaultValue = "1") Integer page) {
		// phân trang comment
		int limit = 10;
		Pageable pageable = new PageRequest(page - 1, limit);
		// Lấy thông tin sản phẩm theo id, comment đã được phân trang
		ProductDto productDto = productService.getProductById(id, pageable);
		// Lấy danh sách sản phẩm liên quan dựa trên genreId của sản phẩm và loại bỏ sản
		// phẩm hiện tại
		int totalPage = (int) Math.ceil((double) productDto.getTotalComment() / limit);
		productDto.setListObject(productService.relatedProductByGenreId(id, productDto.getGenre().getId()));
		mvShare.addObject("productDetail", productDto);
		mvShare.addObject("url", url.relativeUrl(request));
		mvShare.addObject("page", page);
		mvShare.addObject("totalPage", totalPage);
		mvShare.setViewName("/client/productDetail");
		return mvShare;
	}

	@RequestMapping(value = "/tim-kiem-san-pham")
	public ModelAndView searchProduct(@RequestParam("keyword") String keyword, HttpServletRequest request,
			@RequestParam(value = "page", required = false, defaultValue = "1") Integer page) {
		Pageable pageable = new PageRequest(page - 1, limit);
		int totalPage = (int) Math.ceil((double) productService.countByKeyword(keyword) / limit);
		productDto.setTotalPage(totalPage);
		productDto.setPage(page);
		// lấy ra danh sách product dựa theo keyword
		productDto.setListObject(productService.searchProduct(keyword, pageable));
		mvShare.addObject("productsFilter", productDto);
		mvShare.addObject("url", url.relativeUrl(request));
		mvShare.addObject("search", keyword);
		addCommonObjectsToModelAndView("/client/filter-search");
		return mvShare;
	}

	@RequestMapping(value = { "/danh-muc", "/thuong-hieu" })
	public ModelAndView filter(@RequestParam(value = "genreId", required = false) Integer genreId,
			@RequestParam(value = "manufacturerId", required = false) Integer manufacturerId,
			@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
			HttpServletRequest request) {
		Pageable pageable = new PageRequest(page - 1, limit);
		int totalPage = 0;
		// nếu nhấn vào lọc theo genre thì genreId != null, ngược lại manufacturerId !=
		// null
		if (genreId != null) {
			// tính tổng số trang = số sản phẩm của genre hoặc manufacturer chia cho limit
			totalPage = (int) Math.ceil((double) productService.countByParam("genre", genreId) / limit);
			// danh sách các product đã được phân trang dựa theo spage và limit
			productDto.setListObject(productService.getProductByGenreId(genreId, pageable));
		} else if (manufacturerId != null) {
			totalPage = (int) Math.ceil((double) productService.countByParam("manufacturer", manufacturerId) / limit);
			productDto.setListObject(productService.getProductByManufacturerId(manufacturerId, pageable));
		}
		productDto.setTotalPage(totalPage);
		productDto.setPage(page);
		mvShare.addObject("url", url.relativeUrl(request));
		mvShare.addObject("productsFilter", productDto);
		addCommonObjectsToModelAndView("/client/filter-search");
		return mvShare;
	}

	private void addCommonObjectsToModelAndView(String viewName) {
		mvShare.addObject("manufacturersFilter", manufacturerService.getAllManufacturer());
		mvShare.addObject("genresFilter", genreService.getAllGenre());
		mvShare.setViewName(viewName);
	}

}
