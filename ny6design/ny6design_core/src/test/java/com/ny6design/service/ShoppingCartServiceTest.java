package com.ny6design.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ny6design.core.Env;
import com.ny6design.model.Order;
import com.ny6design.model.OrderDetail;
import com.ny6design.model.ShoppingCart;

public class ShoppingCartServiceTest {
	static ApplicationContext context = new ClassPathXmlApplicationContext("/testContext.xml");
	ShoppingCartService shoppingCartService;

	@Before
	public void init() {
		shoppingCartService = Env.getBean("shoppingCartService");
	}

	@Test
	public void testGetShoppingCart() {
		ShoppingCart cart = shoppingCartService.getShoppingCart(0);
		System.out.println(cart.getId());
	}

	@Test
	public void addProductToCart() {
		ShoppingCart cart = shoppingCartService.getShoppingCart(1);
		OrderDetail order1 = shoppingCartService.addProductToCart(cart, 49, 2);
		System.out.println(order1.getProduct().getPrice());
		OrderDetail order2 = shoppingCartService.addProductToCart(cart, 50, 3);
		System.out.println(order2.getProduct().getPrice());
	}

	@Test
	public void getAllOrders() {
		List<OrderDetail> list = shoppingCartService.getAllOrders(1);
		for (OrderDetail detail : list) {
			System.out.println(detail.getOrder().getId() + "/" + detail.getProduct().getProductId());
		}
	}
	
	@Test
	public void removeOrderFromCart() {
		shoppingCartService.removeOrderFromCart(1);
	}

}
