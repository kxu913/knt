package com.ny6design.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ny6design.core.Env;
import com.ny6design.model.WishListKey;

public class WishListServiceTest {
	
	static ApplicationContext context = new ClassPathXmlApplicationContext(
			"/testContext.xml");
	
	WishListService wishListService;
	
	@Before
	public void init() {
		wishListService = Env.getBean("wishListService");
	}
	
	@Test
	public void TestInsertWishProduct(){
		WishListKey wishListKey = new WishListKey();
		wishListKey.setProductId(49);
		wishListKey.setUserId(13);
		//delete it first
		wishListService.deleteWishProduct(wishListKey);
		//then insert
		wishListService.insertWishProduct(wishListKey);
		
		if(wishListService.getWishListByUserId(13).size()>0){
			assertThat(wishListService.getWishListByUserId(13).get(0).getProductId()).isEqualTo(49);
		}
	}
	
	@Test
	public void TestDeleteWishProduct(){
		WishListKey wishListKey = new WishListKey();
		wishListKey.setProductId(49);
		wishListKey.setUserId(13);
		wishListService.deleteWishProduct(wishListKey);
		
		assertThat(wishListService.getWishListByUserId(13).size()).isLessThanOrEqualTo(0);
	}
	
	@Test
	public void TestGetWishListByUserId(){
		WishListKey wishListKey = new WishListKey();
		wishListKey.setProductId(49);
		wishListKey.setUserId(13);
		wishListService.insertWishProduct(wishListKey);
		
		wishListKey.setProductId(50);
		wishListKey.setUserId(13);
		wishListService.insertWishProduct(wishListKey);
		
		wishListKey.setProductId(51);
		wishListKey.setUserId(13);
		wishListService.insertWishProduct(wishListKey);
		
		
		assertThat(wishListService.getWishListByUserId(13).size()).isEqualTo(3);
	}
	
	
}
