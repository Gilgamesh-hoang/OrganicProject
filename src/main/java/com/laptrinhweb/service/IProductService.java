package com.laptrinhweb.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.laptrinhweb.dto.ProductDto;
import com.laptrinhweb.entity.ProductEntity;

public interface IProductService {
	List<ProductDto> getAllProduct(Pageable pageable);

	List<ProductDto> searchProduct(String keyword, Pageable pageable);

	List<ProductDto> getProductByGenreId(int id, Pageable pageable);

	List<ProductDto> getProductByManufacturerId(int id, Pageable pageable);

	List<ProductDto> relatedProductByGenreId(int productId, int genreId);

	ProductDto getProductById(int id, Pageable pageable);

	ProductDto checkOutProduct(int quantity, ProductEntity entity);

	int getTotalProduct();

	int countByKeyword(String keyword);

	int countByParam(String param, int id);
}
