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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "checkout")
@EntityListeners(AuditingEntityListener.class) // de su dung createdBy..., duoc cau hinh trong jpaAuditingConfig
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToMany(mappedBy = "orderEntity", fetch = FetchType.LAZY)
	private List<OrderItemEntity> listOrderItem;

	@Column(name = "order_date")
	@Temporal(TemporalType.DATE)
	@CreatedDate
	private Date orderDate;

	@Column(name = "note")
	private String note;

	@Column(name = "status")
	private String status;

	@Column(name = "total_price")
	private double totalPrice;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity userOrder;

	@ManyToOne
	@JoinColumn(name = "address_id")
	private AddressEntity address;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	public List<OrderItemEntity> getListOrderItem() {
		return listOrderItem;
	}

	public void setListOrderItem(List<OrderItemEntity> listOrderItem) {
		this.listOrderItem = listOrderItem;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public UserEntity getUserOrder() {
		return userOrder;
	}

	public void setUserOrder(UserEntity userOrder) {
		this.userOrder = userOrder;
	}

}
