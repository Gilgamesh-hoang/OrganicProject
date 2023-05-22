package com.laptrinhweb.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.laptrinhweb.entity.BlogEntity;

public interface IBlogRepository extends JpaRepository<BlogEntity, Integer> {

	@Query("SELECT b FROM BlogEntity b WHERE b.category.categoryId = :categoryId")
	List<BlogEntity> findByCategoryId(@Param("categoryId") int categoryId, Pageable pageable);

	// đếm số lượng các blog dựa trên title hoặc categoryName thông qua keyword(dùng
	// để phân trang)
	@Query("SELECT COUNT(b) FROM BlogEntity b WHERE b.title LIKE %:keyword% OR b.category.categoryName LIKE %:keyword%")
	int countByKeyword(@Param("keyword") String keyword);

	// lấy ra danh sách các blog mới nhất dựa trên createdDate, pageable ở đây không
	// phải dùng để phân trang mà dùng để thay thế cho limit
	@Query("SELECT b FROM BlogEntity b ORDER BY b.createdDate DESC")
	List<BlogEntity> topNewBlog(Pageable pageable);

	@Query("SELECT b FROM BlogEntity b WHERE b.title LIKE %:keyword% OR b.category.categoryName LIKE %:keyword% ")
	List<BlogEntity> searchBlog(@Param("keyword") String keyword, Pageable pageable);

	@Query("SELECT COUNT(b) FROM BlogEntity b WHERE b.category.categoryId = :categoryId")
	int countBlogByCategoryId(@Param("categoryId") int categoryId);

	/**
	 * value để truyền vào câu truy vấn SQL. nativeQuery = true để báo cho Spring
	 * biết đây là câu truy vấn SQL, không phải JPQL. RAND() để lấy ngẫu nhiên 3
	 * blog LIMIT 3 để chỉ định số lượng blog cần lấy ra. blogId <>:blogId để bỏ qua
	 * blog có blogId truyền vào
	 */
	@Query(value = "SELECT * FROM blog WHERE blogId <> :blogId ORDER BY RAND() LIMIT 3", nativeQuery = true)
	List<BlogEntity> blogMayLike(@Param("blogId") int blogId);

	@Query(value = "SELECT * FROM blog ORDER BY RAND() LIMIT 3", nativeQuery = true)
	List<BlogEntity> blogRandom();

}
