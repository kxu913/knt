package com.ny6design.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ny6design.core.Env;
import com.ny6design.model.Order;

public class OrderServiceTest {
	static ApplicationContext context = new ClassPathXmlApplicationContext(
			"/testContext.xml");
	OrderService orderService;

	@Before
	public void init() {
		orderService = Env.getBean("orderService");
	}
	@Test
	public void testInsertOrder() {
//		Order o = 
	}

}
