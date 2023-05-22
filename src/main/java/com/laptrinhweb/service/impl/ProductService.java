package com.laptrinhweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.laptrinhweb.dto.ProductDto;
import com.laptrinhweb.entity.CommentProductEntity;
import com.laptrinhweb.entity.ProductEntity;
import com.laptrinhweb.mapper.ProductMapper;
import com.laptrinhweb.repository.ICommentProductRepository;
import com.laptrinhweb.repository.IProductRepository;
import com.laptrinhweb.service.IProductService;

@Service
public class ProductService implements IProductService {
	@Autowired
	private IProductRepository productRepository;
	@Autowired
	private ICommentProductRepository commentProductRepository;
	@Autowired
	private ProductMapper productMapper;

	@Override
	public List<ProductDto> getAllProduct(Pageable pageable) {
		List<ProductEntity> entities = productRepository.findAll(pageable).getContent();
		return productMapper.toDTO(entities);
	}

	@Override
	public ProductDto getProductById(int id, Pageable pageable) {
		ProductEntity entity = productRepository.findOne(id);
		int totalComment = entity.getListComment().size();
		Page<CommentProductEntity> commentPage = commentProductRepository.findCommentByProduct(entity, pageable);
		List<CommentProductEntity> comments = commentPage.getContent();
		entity.setListComment(comments);
		// Chuyển đổi entity và danh sách comment thành DTO
		ProductDto dto = productMapper.toDTO(entity);
		dto.setTotalComment(totalComment);
		return dto;
	}

	@Override
	public List<ProductDto> getProductByGenreId(int id, Pageable pageable) {
		List<ProductEntity> entities = productRepository.findByGenreId(id, pageable);
		return productMapper.toDTO(entities);
	}

	@Override
	public List<ProductDto> getProductByManufacturerId(int id, Pageable pageable) {
		List<ProductEntity> entities = productRepository.findByManufacturerId(id, pageable);
		return productMapper.toDTO(entities);
	}

	@Override
	public int getTotalProduct() {
		// đếm tất cả các product
		return (int) productRepository.count();
	}

	@Override
	public List<ProductDto> searchProduct(String keyword, Pageable pageable) {
		// tìm kiếm product dựa trên keyword
		List<ProductEntity> entities = productRepository.findByKeyword(keyword, pageable);
		return productMapper.toDTO(entities);
	}

	@Override
	public int countByParam(String param, int id) {
		return productRepository.countByParam(param, id);
	}

	@Override
	public int countByKeyword(String keyword) {
		return productRepository.countByKeyword(keyword);
	}

	@Override
	public List<ProductDto> relatedProductByGenreId(int productId, int genreId) {
		// lấy ra các sản phẩm có liên quan với productId thông qua genreId nhưng không
		// bao gồm productId
		List<ProductEntity> entities = productRepository.relatedProductByGenreId(productId, genreId);
		return productMapper.toDTO(entities);
	}

	@Override
	public ProductDto checkOutProduct(int quantity, ProductEntity entity) {
		// khi người dùng mua hàng thành công thì sẽ cập nhật sold và available
		entity.setAvailable(entity.getAvailable() - quantity);
		entity.setSold(entity.getSold() + quantity);
		return productMapper.toDTO(productRepository.save(entity));
	}
}
