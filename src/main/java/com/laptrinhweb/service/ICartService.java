package com.laptrinhweb.service;

import com.laptrinhweb.dto.CartDto;

public interface ICartService {

	boolean addProductToCart(int productId, int quantity);

	CartDto getCart();

	CartDto getCartCheckout();

	boolean updateQuantityInCart(int cartItemId, int quantity);

	boolean deleteCartItem(int cartItemId);

}
