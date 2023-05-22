package com.laptrinhweb.dto;

import java.util.Date;
import java.util.List;

public class OrderDto {
	private int id;
	private List<OrderItemDto> listOrderItem;
	private Date orderDate;
	private String note;
	private String status;
	private double totalPrice;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<OrderItemDto> getListOrderItem() {
		return listOrderItem;
	}

	public void setListOrderItem(List<OrderItemDto> listOrderItem) {
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
