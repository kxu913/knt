package com.ny6design.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ny6design.model.WishListKey;
import com.ny6design.service.WishListService;


@Controller
public class WishListController {
	
	@Autowired
	WishListService wishListService;
	
	@ResponseBody
	@RequestMapping(value="wishlist/add/{userId}/{productId}", method=RequestMethod.GET)
	public void add2WishList(@PathVariable Integer userId, 
			@PathVariable Integer productId, ModelMap model){
		WishListKey wishListKey = new WishListKey();
		wishListKey.setProductId(productId);
		wishListKey.setUserId(userId);
		wishListService.insertWishProduct(wishListKey);
	}

}
