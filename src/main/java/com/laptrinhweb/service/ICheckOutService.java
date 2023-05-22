package com.laptrinhweb.service;

import java.util.List;

import com.laptrinhweb.dto.OrderDto;

public interface ICheckOutService {

	boolean order(String note);

	List<OrderDto> getListOrder();

	OrderDto getOrderById(int id);

}
