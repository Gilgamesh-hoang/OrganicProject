package com.laptrinhweb.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.laptrinhweb.dto.OrderDto;
import com.laptrinhweb.entity.CartItemEntity;
import com.laptrinhweb.entity.OrderEntity;
import com.laptrinhweb.entity.OrderItemEntity;

@Component
public class CheckOutMapper extends GeneralMapper<OrderDto, OrderEntity> {
	@Autowired
	private ModelMapper modelMapper;

	public List<OrderItemEntity> cartItemToOrderItem(List<CartItemEntity> cartItems, OrderEntity orderEntity) {
		List<OrderItemEntity> result = new ArrayList<>();
		for (CartItemEntity cartItem : cartItems) {
			OrderItemEntity itemEntity = modelMapper.map(cartItem, OrderItemEntity.class);
			itemEntity.setOrderEntity(orderEntity);
			result.add(itemEntity);
		}
		return result;
	}

}
//@Component
//public class CheckOutMapper {
//	@Autowired
//	private ModelMapper modelMapper;
//
//	public List<OrderItemEntity> cartItemToOrderItem(List<CartItemEntity> cartItems, OrderEntity orderEntity) {
//		List<OrderItemEntity> result = new ArrayList<>();
//		for (CartItemEntity cartItem : cartItems) {
//			OrderItemEntity itemEntity = modelMapper.map(cartItem, OrderItemEntity.class);
//			itemEntity.setOrderEntity(orderEntity);
//			result.add(itemEntity);
//		}
//		return result;
//	}
//
//	public List<OrderDto> toDTO(List<OrderEntity> entities) {
//		List<OrderDto> result = new ArrayList<>();
//		for (OrderEntity entity : entities) {
//			result.add(modelMapper.map(entity, OrderDto.class));
//		}
//		return result;
//	}
//
//	public OrderDto toDTO(OrderEntity entity) {
//		return modelMapper.map(entity, OrderDto.class);
//	}
//
//}
