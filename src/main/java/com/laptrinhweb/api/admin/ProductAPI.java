package com.laptrinhweb.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhweb.dto.ProductDto;
import com.laptrinhweb.service.IProductService;

@RestController
public class ProductAPI {
	@Autowired
	private IProductService productService;

	@PostMapping("/admin/api/san-pham")
	public boolean addProduct(@RequestBody ProductDto productDto) {
		return productService.save(productDto);
	}

	@PutMapping("/admin/api/san-pham")
	public boolean updateProduct(@RequestBody ProductDto productDto) {
		return productService.save(productDto);
	}

	@DeleteMapping("/admin/api/san-pham")
	public boolean deleteProduct(@RequestBody int[] ids) {
		return productService.delete(ids);
	}
}
