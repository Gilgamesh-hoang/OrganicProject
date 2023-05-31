package com.laptrinhweb.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhweb.dto.BlogDto;
import com.laptrinhweb.service.IBlogService;

@RestController
public class BlogAPI {
	@Autowired
	IBlogService blogService;

	@PostMapping("/admin/api/blog")
	public boolean addProduct(@RequestBody BlogDto blogDto) {
		return blogService.save(blogDto);
	}

	@PutMapping("/admin/api/blog")
	public boolean updateProduct(@RequestBody BlogDto blogDto) {
		return blogService.save(blogDto);
	}

	@DeleteMapping("/admin/api/blog")
	public boolean deleteProduct(@RequestBody int[] ids) {
		return blogService.delete(ids);
	}
}
