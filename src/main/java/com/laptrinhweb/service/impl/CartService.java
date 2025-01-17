package com.laptrinhweb.service.impl;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhweb.constant.SystemConstant;
import com.laptrinhweb.dto.CartDto;
import com.laptrinhweb.dto.MyUser;
import com.laptrinhweb.entity.CartEntity;
import com.laptrinhweb.entity.CartItemEntity;
import com.laptrinhweb.entity.ProductEntity;
import com.laptrinhweb.entity.UserEntity;
import com.laptrinhweb.mapper.CartMapper;
import com.laptrinhweb.repository.ICartItemRepository;
import com.laptrinhweb.repository.ICartRepository;
import com.laptrinhweb.repository.IProductRepository;
import com.laptrinhweb.repository.IUserRepository;
import com.laptrinhweb.service.ICartService;
import com.laptrinhweb.util.SecurityUtils;

@Service
@Transactional
public class CartService implements ICartService {
	@Autowired
	private ICartRepository cartRepository;
	@Autowired
	private ICartItemRepository itemRepository;
	@Autowired
	private IProductRepository productRepository;
	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private CartMapper cartMapper;

	@Override
	public boolean addProductToCart(int productId, int quantity) {
		ProductEntity productEntity = productRepository.findOne(productId);
		// nếu sản phẩm hết hàng hoặc sản phẩm ngừng kinh doanh
		if (productEntity.getAvailable() == 0 || productEntity.getStatus() == SystemConstant.OUT_OF_BUSINESS) {
			return false;
		}
		// trường hợp số available bé hơn quantity người dùng muốn mua
		quantity = (productEntity.getAvailable() - quantity < 0) ? productEntity.getAvailable() : quantity;
		// lấy id của người dùng đang đăng nhập
		MyUser user = SecurityUtils.getPrincipal();
		CartEntity cartEntity = cart();

		// nếu người dùng đó chưa có giỏ hàng, bước này chỉ thực hiện duy nhất 1 lần khi
		// người dùng thêm vào sản phẩm đầu tiên vào giỏ hàng, những lần sau thì không
		// cần bước này
		if (cartEntity == null) {
			UserEntity userEntity = userRepository.findOne(user.getId());
			cartEntity = new CartEntity();
			cartEntity.setUser(userEntity);
			cartEntity = cartRepository.save(cartEntity);
		}
		CartItemEntity itemEntity = itemRepository.findByProductAndCart(productEntity, cartEntity);
		// nếu chưa tồn tại sản phẩm nào trong chi tiết đơn hàng của giỏ hàng đó thì tạo
		// mới
		if (itemEntity == null) {
			itemEntity = new CartItemEntity();
			itemEntity.setCart(cartEntity);
			itemEntity.setProduct(productEntity);
			itemEntity.setQuantity(quantity);
			itemEntity.setTotalPrice(quantity * productEntity.getPrice());

		} else {// nếu có rồi thì cập nhật số lượng và tổng giá của chi tiết đơn hàng
			itemEntity.setQuantity(itemEntity.getQuantity() + quantity);
			itemEntity.setTotalPrice(itemEntity.getQuantity() * productEntity.getPrice());
		}
		// cập nhật tổng giá và tổng số lượng của giỏ hàng
		cartEntity.setTotalPrice(cartEntity.getTotalPrice() + productEntity.getPrice() * quantity);
		cartEntity.setTotalQuantity(cartEntity.getTotalQuantity() + quantity);
		cartRepository.save(cartEntity);
		itemRepository.save(itemEntity);
		return true;
	}

	public CartEntity cart() {
		MyUser user = SecurityUtils.getPrincipal();
		if (user == null)
			return null;
		return cartRepository.findByUserId(user.getId());
	}

	@Override
	public CartDto getCart() {
		// lấy ra cart, dùng cho giao diện cart
		CartEntity cartEntity = cart();
		if (cartEntity == null)
			return new CartDto();
		else {
			CartDto cartDto = cartMapper.toDTO(cartEntity, CartDto.class);
			return cartDto;
		}
	}

	@Override
	public CartDto getCartCheckout() {
		// lấy ra cart, dùng cho giao diện checkout. Nếu sản phẩm đã hết hàng thì không
		// hiển thị
		CartEntity cartEntity = cart();
		if (cartEntity == null)
			return new CartDto();
		else {
			Stream<CartItemEntity> stream = cartEntity.getItems().stream();
			stream.forEach(itemEntity -> {
				if (itemEntity.getProduct().getAvailable() == 0) {
					cartEntity.getItems().remove(itemEntity);
					cartEntity.setTotalQuantity(cartEntity.getTotalQuantity() - itemEntity.getQuantity());
					cartEntity.setTotalPrice(cartEntity.getTotalPrice() - itemEntity.getTotalPrice());
				}
			});

			CartDto cartDto = cartMapper.toDTO(cartEntity, CartDto.class);
			return cartDto;
		}
	}

	@Override
	public boolean updateQuantityInCart(int cartItemId, int quantity) {
		CartItemEntity itemEntity = itemRepository.findOne(cartItemId);
		if (itemEntity != null) {
			CartEntity cartEntity = itemEntity.getCart();
			ProductEntity productEntity = itemEntity.getProduct();
			// trường hợp số available bé hơn quantity người dùng muốn mua
			quantity = (productEntity.getAvailable() - quantity < 0) ? productEntity.getAvailable() : quantity;
			int oldQuantity = itemEntity.getQuantity();
			double productPrice = itemEntity.getProduct().getPrice();
			// Tính toán sự thay đổi của số lượng và giá trị tổng cộng
			int quantityDiff = quantity - oldQuantity;
			double totalPriceDiff = quantityDiff * productPrice;

			// Cập nhật thông tin của CartItemEntity
			itemEntity.setQuantity(quantity);
			itemEntity.setTotalPrice(quantity * productPrice);

			// Cập nhật thông tin của CartEntity
			cartEntity.setTotalQuantity(cartEntity.getTotalQuantity() + quantityDiff);
			cartEntity.setTotalPrice(cartEntity.getTotalPrice() + totalPriceDiff);

			itemRepository.save(itemEntity);
			cartRepository.save(cartEntity);
			return true;
		}

		return false;
	}

	@Override
	public boolean deleteCartItem(int cartItemId) {
		CartItemEntity itemEntity = itemRepository.findOne(cartItemId);
		if (itemEntity != null) {
			CartEntity cartEntity = itemEntity.getCart();
			cartEntity.setTotalPrice(cartEntity.getTotalPrice() - itemEntity.getTotalPrice());
			cartEntity.setTotalQuantity(cartEntity.getTotalQuantity() - itemEntity.getQuantity());
			itemRepository.delete(itemEntity);
			cartRepository.save(cartEntity);
			return true;
		}
		return false;
	}

}
