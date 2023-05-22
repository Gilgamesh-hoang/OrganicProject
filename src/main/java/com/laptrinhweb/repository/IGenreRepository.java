package com.laptrinhweb.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.laptrinhweb.entity.GenreEntity;

public interface IGenreRepository extends JpaRepository<GenreEntity, Integer> {
	@Query("SELECT m FROM GenreEntity m LEFT JOIN m.listProduct p GROUP BY m ORDER BY COUNT(p) DESC")
	List<Object> countProductsByManufacturer();

	// lay ra danh sach cac genre kem theo so luong san pham cua genre do
	default List<GenreEntity> getProductCountByGenre() {
		List<Object> list = countProductsByManufacturer();
		List<GenreEntity> result = new ArrayList<>();
		for (Object entry : list) {
			result.add((GenreEntity) entry);
		}

		return result;
	}
}
