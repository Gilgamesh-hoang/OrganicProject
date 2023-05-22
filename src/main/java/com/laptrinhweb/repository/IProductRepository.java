package com.laptrinhweb.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.laptrinhweb.entity.ProductEntity;

public interface IProductRepository extends JpaRepository<ProductEntity, Integer> {
	List<ProductEntity> findByGenreId(int id, Pageable pageable);

	List<ProductEntity> findByManufacturerId(int id, Pageable pageable);

	// đếm số lượng product dựa trên manufacturerId hoặc là genre(dùng để phân
	// trang)
	@Query("SELECT COUNT(p) FROM ProductEntity p WHERE " + "CASE :param "
			+ "WHEN 'manufacturer' THEN p.manufacturer.id " + "WHEN 'genre' THEN p.genre.id END = :id")
	int countByParam(@Param("param") String param, @Param("id") int id);

	// đếm số lượng các product dựa trên productName hoặc manufacturerName hoặc
	// genreName thông qua keyword(dùng để phân trang)
	@Query("SELECT COUNT(p) FROM ProductEntity p WHERE p.productName LIKE %:keyword% OR p.manufacturer.manufacturerName LIKE %:keyword% OR p.genre.genreName LIKE %:keyword%")
	int countByKeyword(@Param("keyword") String keyword);

	/**
	 * tim kiem theo ten san pham hoac ten nha san xuat hoac ten danh
	 * muc @Param("keyword") được sử dụng để đặt tên cho tham số truyền vào chúng ta
	 * sử dụng :keyword để tham chiếu đến tham số String keyword Spring Data JPA sẽ
	 * biết rằng tham số String keyword sẽ được gắn vào vị trí :keyword trong câu
	 * truy vấn SQL.
	 */
	@Query("SELECT p FROM ProductEntity p WHERE p.productName LIKE %:keyword% OR p.manufacturer.manufacturerName LIKE %:keyword% OR p.genre.genreName LIKE %:keyword%")
	List<ProductEntity> findByKeyword(@Param("keyword") String keyword, Pageable pageable);

	/**
	 * value để truyền vào câu truy vấn SQL. nativeQuery = true để báo cho Spring
	 * biết đây là câu truy vấn SQL, không phải JPQL RAND() để lấy ngẫu nhiên 4 sản
	 * phẩm. LIMIT 4 để chỉ định số lượng sản phẩm cần lấy ra. product_id <>
	 * :productId để bỏ qua sản phẩm có productId truyền vào
	 */
//	@Query(value = "SELECT * FROM product WHERE genre_id = :genreId AND id <> :productId ORDER BY RAND() LIMIT 4", nativeQuery = true)
	@Query(value = "SELECT * FROM product WHERE genre_id = :genreId AND productId <> :productId ORDER BY RAND() LIMIT 4", nativeQuery = true)
	List<ProductEntity> relatedProductByGenreId(@Param("productId") int productId, @Param("genreId") int genreId);

}
