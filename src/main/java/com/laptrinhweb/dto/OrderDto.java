package com.laptrinhweb.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
	@Getter
	@Setter
	private int id;
	private List<OrderItemDto> listOrderItem;
	private Date orderDate;
	private String note;
	private String status;
	private double totalPrice;
	private String email;
	private String fullName;
	private String phoneNumber;
	private String address;

}
