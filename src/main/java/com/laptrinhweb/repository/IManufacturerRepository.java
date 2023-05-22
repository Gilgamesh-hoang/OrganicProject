package com.laptrinhweb.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.laptrinhweb.entity.ManufacturerEntity;

public interface IManufacturerRepository extends JpaRepository<ManufacturerEntity, Integer> {

	@Query("SELECT m FROM ManufacturerEntity m LEFT JOIN m.listProduct p GROUP BY m ORDER BY COUNT(p) DESC")
	List<Object> countProductsByManufacturer();

	// lấy ra danh sách các Manufacturer kèm theo đó là số product của Manufacturer
	// đó
	default List<ManufacturerEntity> getProductCountByManufacturer() {
		List<Object> list = countProductsByManufacturer();
		List<ManufacturerEntity> result = new ArrayList<>();
		for (Object entry : list) {
			result.add((ManufacturerEntity) entry);
		}
		return result;
	}

}
