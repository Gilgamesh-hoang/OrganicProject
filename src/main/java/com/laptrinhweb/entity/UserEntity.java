package com.laptrinhweb.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class) // de su dung createdBy..., duoc cau hinh trong jpaAuditingConfig
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

	@Column(name = "verify_code")
	private String verifyCode;

	@Column(name = "active")
	private short active;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<RoleEntity> roles;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ContactEntity> contact;

	@OneToMany(mappedBy = "userOrder", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<OrderEntity> listOrder;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<AddressEntity> listAddress;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<CommentBlogEntity> listCommentBlog;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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

}
