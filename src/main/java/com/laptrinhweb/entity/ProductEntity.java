package com.laptrinhweb.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "product")
@EntityListeners(AuditingEntityListener.class)
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "price")
	private double price;

	@Column(name = "image")
	private String image;

	@Column(name = "available")
	private int available;

	@Column(name = "sold")
	private int sold;

	@Column(name = "discount")
	private double discount;

	@Column(name = "weight")
	private double weight;

	@Column(name = "description", columnDefinition = "TEXT")
	private String description;

	@Column(name = "status")
	private short status;

	@Column(name = "rate")
	private Short rate;

	@ManyToOne
	@JoinColumn(name = "genre_id")
	private GenreEntity genre;

	@ManyToOne
	@JoinColumn(name = "manufacturer_id")
	private ManufacturerEntity manufacturer;

	@OneToMany(mappedBy = "product")
	private List<CartItemEntity> listCartItem;

	@OneToMany(mappedBy = "product")
	private List<WishListProductEntity> wishListProduct;

	@OneToMany(mappedBy = "product")
	private List<OrderItemEntity> orderItem;

	@OneToMany(mappedBy = "product")
	private List<CommentProductEntity> listComment;

	@Column(name = "created_by")
	@CreatedBy
	private String createdBy;

	@Column(name = "modified_by")
	@LastModifiedBy
	private String modifiedBy;

	@Column(name = "created_date")
	@Temporal(TemporalType.DATE)
	@CreatedDate
	private Date createdDate;

	@Column(name = "modified_date")
	@Temporal(TemporalType.DATE)
	@LastModifiedDate
	private Date modifiedDate;

	public List<CommentProductEntity> getListComment() {
		return listComment;
	}

	public void setListComment(List<CommentProductEntity> listComment) {
		this.listComment = listComment;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	public Short getRate() {
		return rate;
	}

	public void setRate(Short rate) {
		this.rate = rate;
	}

	public GenreEntity getGenre() {
		return genre;
	}

	public void setGenre(GenreEntity genre) {
		this.genre = genre;
	}

	public ManufacturerEntity getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(ManufacturerEntity manufacturer) {
		this.manufacturer = manufacturer;
	}

	public List<CartItemEntity> getListCartItem() {
		return listCartItem;
	}

	public void setListCartItem(List<CartItemEntity> listCartItem) {
		this.listCartItem = listCartItem;
	}

	public List<WishListProductEntity> getWishListProduct() {
		return wishListProduct;
	}

	public void setWishListProduct(List<WishListProductEntity> wishListProduct) {
		this.wishListProduct = wishListProduct;
	}

	public List<OrderItemEntity> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(List<OrderItemEntity> orderItem) {
		this.orderItem = orderItem;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
