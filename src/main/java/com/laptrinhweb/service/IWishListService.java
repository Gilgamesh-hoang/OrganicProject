package com.laptrinhweb.service;

import com.laptrinhweb.dto.WishListDto;

public interface IWishListService {
	boolean addWishList(int productId);

	boolean deleteWishListItem(int wishlistItemId);

	WishListDto getWishList();

	int numberProductLike();

}
