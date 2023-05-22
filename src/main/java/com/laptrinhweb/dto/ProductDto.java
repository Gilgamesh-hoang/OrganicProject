package com.laptrinhweb.dto;

import java.util.List;

import com.laptrinhweb.entity.ManufacturerEntity;

public class ProductDto extends AbstractDto<ProductDto> {
	private String productName;
	private double price;
	private String image;
	private int available;
	private int sold;
	private double discount;
	private double weight;
	private String description;
	private short status;
	private GenreDto genre;
	private short rate;
	private ManufacturerEntity manufacturer;
	private List<CommentProductDto> listComment;
	private int totalComment;

	public int getTotalComment() {
		return totalComment;
	}

	public void setTotalComment(int totalComment) {
		this.totalComment = totalComment;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public short getRate() {
		return rate;
	}

	public void setRate(short rate) {
		this.rate = rate;
	}

	public List<CommentProductDto> getListComment() {
		return listComment;
	}

	public void setListComment(List<CommentProductDto> listComment) {
		this.listComment = listComment;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public int getSold() {
		return sold;
	}

	public void setSold(int sold) {
		this.sold = sold;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public GenreDto getGenre() {
		return genre;
	}

	public void setGenre(GenreDto genre) {
		this.genre = genre;
	}

	public ManufacturerEntity getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(ManufacturerEntity manufacturer) {
		this.manufacturer = manufacturer;
	}

}
