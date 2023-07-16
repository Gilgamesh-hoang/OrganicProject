package com.laptrinhweb.service;

import com.laptrinhweb.dto.WishListDto;

public interface IWishListService {
	boolean addWishList(int productId);

	void deleteWishListItem(int wishlistItemId);

	WishListDto getWishList();

	int numberProductLike();

}
