package com.laptrinhweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhweb.dto.MyUser;
import com.laptrinhweb.dto.WishListDto;
import com.laptrinhweb.entity.ProductEntity;
import com.laptrinhweb.entity.UserEntity;
import com.laptrinhweb.entity.WishListEntity;
import com.laptrinhweb.entity.WishListProductEntity;
import com.laptrinhweb.mapper.WishListMapper;
import com.laptrinhweb.repository.IProductRepository;
import com.laptrinhweb.repository.IUserRepository;
import com.laptrinhweb.repository.IWishListProductRepository;
import com.laptrinhweb.repository.IWishListRepository;
import com.laptrinhweb.service.IWishListService;
import com.laptrinhweb.util.SecurityUtils;

@Service
@Transactional
public class WishListService implements IWishListService {
	@Autowired
	private IWishListRepository wishListRepository;
	@Autowired
	private IWishListProductRepository listProductRepository;
	@Autowired
	private IProductRepository productRepository;
	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private WishListMapper wishListMapper;

	@Override
	public boolean addWishList(int productId) {
		ProductEntity productEntity = productRepository.findOne(productId);
		MyUser myUser = SecurityUtils.getPrincipal();
		WishListEntity wishList = wishListRepository.findOneByUserId(myUser.getId());

		// nếu wishlist của người dùng chưa có thì tạo mới
		if (wishList == null) {
			UserEntity user = userRepository.findOne(myUser.getId());
			wishList = new WishListEntity();
			wishList.setUser(user);
			wishList = wishListRepository.save(wishList);
		}

		WishListProductEntity listProduct = listProductRepository.findOneByProductAndWishList(productEntity, wishList);
		// nếu sản phẩm chưa có trong wishList thì thêm
		if (listProduct == null) {
			listProduct = new WishListProductEntity();
			listProduct.setProduct(productEntity);
			listProduct.setWishList(wishList);
			listProductRepository.save(listProduct);
			return true;
		}

		return false;
	}

	@Override
	public WishListDto getWishList() {
		MyUser myUser = SecurityUtils.getPrincipal();
		WishListEntity wishList = wishListRepository.findOneByUserId(myUser.getId());
		if (wishList == null) {
			return new WishListDto();
		} else {
			return wishListMapper.toDTO(wishList, WishListDto.class);
		}
	}

	@Override
	public boolean deleteWishListItem(int wishlistItemId) {
		WishListProductEntity itemProduct = listProductRepository.findOne(wishlistItemId);
		if (itemProduct != null) {
			listProductRepository.delete(itemProduct);
			return true;
		}
		return false;
	}

	@Override
	public int numberProductLike() {
		return (getWishList().getProducts() == null) ? 0 : getWishList().getProducts().size();
	}

}
