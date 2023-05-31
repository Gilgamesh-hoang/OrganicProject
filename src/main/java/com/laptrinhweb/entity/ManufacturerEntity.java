package com.laptrinhweb.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "manufacturer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ManufacturerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "manufacturer_name")
	private String manufacturerName;

	@Column(name = "manufacturer_image")
	private String image;

	@Column(name = "manufacturer_description", columnDefinition = "TEXT")
	private String description;

	@OneToMany(mappedBy = "manufacturer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ProductEntity> listProduct;

}
