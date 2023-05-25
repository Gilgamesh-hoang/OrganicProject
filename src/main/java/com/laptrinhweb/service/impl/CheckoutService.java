package com.laptrinhweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhweb.constant.SystemConstant;
import com.laptrinhweb.dto.MyUser;
import com.laptrinhweb.dto.OrderDto;
import com.laptrinhweb.entity.CartEntity;
import com.laptrinhweb.entity.CartItemEntity;
import com.laptrinhweb.entity.OrderEntity;
import com.laptrinhweb.entity.OrderItemEntity;
import com.laptrinhweb.entity.UserEntity;
import com.laptrinhweb.mapper.AddressMapper;
import com.laptrinhweb.mapper.CheckOutMapper;
import com.laptrinhweb.repository.ICartRepository;
import com.laptrinhweb.repository.ICheckoutItemRepository;
import com.laptrinhweb.repository.ICheckoutRepository;
import com.laptrinhweb.repository.IUserRepository;
import com.laptrinhweb.service.ICartService;
import com.laptrinhweb.service.ICheckOutService;
import com.laptrinhweb.service.IProductService;
import com.laptrinhweb.util.SecurityUtils;

@Service
@Transactional
public class CheckoutService implements ICheckOutService {
	@Autowired
	private ICheckoutRepository checkoutRepository;
	@Autowired
	private ICheckoutItemRepository checkoutItemRepository;
	@Autowired
	private ICartService cartService;
	@Autowired
	private IProductService productService;
	@Autowired
	private ICartRepository cartRepository;
	@Autowired
	private CheckOutMapper checkOutMapper;
	@Autowired
	private AddressMapper addressMapper;
	@Autowired
	private IUserRepository userRepository;

	@Override
	public boolean order(String note) {
		OrderEntity orderEntity = new OrderEntity();
		MyUser user = SecurityUtils.getPrincipal();
		CartEntity cartEntity = cartRepository.findByUserId(user.getId());

		if (cartEntity.getTotalQuantity() == 0) {
			return false;
		}

		// cập nhật lại khi thanh toán, những sản phẩm nào khi thanh toán mà đã hết hàng
		// thì không thanh toán sản phẩm đó
		List<CartItemEntity> listCartItem = new ArrayList<>(cartEntity.getItems());
		for (CartItemEntity item : listCartItem) {
			if (item.getProduct().getAvailable() == 0) {
				cartEntity.getItems().remove(item);
				cartEntity.setTotalQuantity(cartEntity.getTotalQuantity() - item.getQuantity());
				cartEntity.setTotalPrice(cartEntity.getTotalPrice() - item.getTotalPrice());
			}
		}

		// lưu đơn hàng
		orderEntity.setTotalPrice(cartEntity.getTotalPrice());
		orderEntity.setNote(note);
		orderEntity.setUserOrder(cartEntity.getUser());
		orderEntity.setStatus(SystemConstant.PROCESSING);
		orderEntity.setAddress(user.getAddress().getAddress());
		orderEntity.setEmail(user.getAddress().getEmail());
		orderEntity.setFullName(user.getAddress().getFullName());
		orderEntity.setPhoneNumber(user.getAddress().getPhoneNumber());
		orderEntity = checkoutRepository.save(orderEntity);

		// lưu các item của đơn hàng đó
		List<OrderItemEntity> items = checkOutMapper.cartItemToOrderItem(cartEntity.getItems(), orderEntity);
		checkoutItemRepository.save(items);

		// sau khi đặt hàng xong thì sẽ xóa các sản phẩm trong cart
		// nhưng trước đó phải cập nhật sold và available trong product
		for (CartItemEntity item : listCartItem) {
			productService.checkOutProduct(item.getQuantity(), item.getProduct());
			cartService.deleteCartItem(item.getId());
		}
		return orderEntity.getId() > 0;
	}

	@Override
	public List<OrderDto> getListOrder() {
		MyUser user = SecurityUtils.getPrincipal();
		UserEntity userEntity = userRepository.findOne(user.getId());
		List<OrderEntity> orderEntity = checkoutRepository.findByUserOrder(userEntity);
		return checkOutMapper.toDTO(orderEntity);
	}

	@Override
	public OrderDto getOrderById(int id) {
		OrderEntity orderEntity = checkoutRepository.findOne(id);
		return checkOutMapper.toDTO(orderEntity);
	}

}
