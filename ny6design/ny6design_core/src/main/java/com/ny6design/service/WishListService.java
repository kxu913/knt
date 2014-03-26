package com.ny6design.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ny6design.mapper.WishListMapper;
import com.ny6design.model.WishListKey;


@Service
public class WishListService {
	
	@Autowired
	private WishListMapper wishListMapper;
	
	public void insertWishProduct(WishListKey wishListKey){
		wishListMapper.insert(wishListKey);
	}
	
	public void deleteWishProduct(WishListKey wishListKey){
		wishListMapper.deleteByPrimaryKey(wishListKey);
	}
	
	public List<WishListKey> getWishListByUserId(Integer userId){
		return wishListMapper.getWishListByUserId(userId);
	}

}
