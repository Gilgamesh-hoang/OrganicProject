package com.laptrinhweb.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class) // de su dung createdBy..., duoc cau hinh trong jpaAuditingConfig
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "full_name")
	private String fullName;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "active")
	private short active;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<RoleEntity> roles;

	@OneToMany(mappedBy = "user")
	private List<ContactEntity> contact;

	@OneToMany(mappedBy = "userOrder")
	private List<OrderEntity> listOrder;

	@OneToMany(mappedBy = "user")
	private List<AddressEntity> listAddress;

	@OneToMany(mappedBy = "user")
	private List<CommentBlogEntity> listCommentBlog;

	@OneToMany(mappedBy = "user")
	private List<CommentProductEntity> listCommentProduct;

	@OneToOne(mappedBy = "user")
	private CartEntity cart;

	@OneToOne(mappedBy = "user")
	private WishListEntity wishListtEntity;

	@Column(name = "created_date")
	@Temporal(TemporalType.DATE)
	@CreatedDate
	private Date createdDate;

	@Column(name = "modified_date")
	@Temporal(TemporalType.DATE)
	@LastModifiedDate
	private Date modifiedDate;

	public List<CommentBlogEntity> getListCommentBlog() {
		return listCommentBlog;
	}

	public void setListCommentBlog(List<CommentBlogEntity> listCommentBlog) {
		this.listCommentBlog = listCommentBlog;
	}

	public List<CommentProductEntity> getListCommentProduct() {
		return listCommentProduct;
	}

	public void setListCommentProduct(List<CommentProductEntity> listCommentProduct) {
		this.listCommentProduct = listCommentProduct;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public short getActive() {
		return active;
	}

	public void setActive(short active) {
		this.active = active;
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

	public List<ContactEntity> getContact() {
		return contact;
	}

	public void setContact(List<ContactEntity> contact) {
		this.contact = contact;
	}

	public List<OrderEntity> getListOrder() {
		return listOrder;
	}

	public void setListOrder(List<OrderEntity> listOrder) {
		this.listOrder = listOrder;
	}

	public CartEntity getCart() {
		return cart;
	}

	public void setCart(CartEntity cart) {
		this.cart = cart;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<AddressEntity> getListAddress() {
		return listAddress;
	}

	public void setListAddress(List<AddressEntity> listAddress) {
		this.listAddress = listAddress;
	}

	public WishListEntity getWishListtEntity() {
		return wishListtEntity;
	}

	public void setWishListtEntity(WishListEntity wishListtEntity) {
		this.wishListtEntity = wishListtEntity;
	}

	public List<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}

}
