package com.ny6design.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ny6design.core.Env;
import com.ny6design.model.OrderDetail;
import com.ny6design.model.OrderSummaryDetail;

public class OrderSummayServiceTest {
	static ApplicationContext context = new ClassPathXmlApplicationContext("/testContext.xml");
	OrderSummayService orderService;

	@Before
	public void init() {
		orderService = Env.getBean("orderSummayService");
	}

	@Test
	public void testFindOrdersByUserId() {
		List<OrderSummaryDetail> list = orderService.findOrdersByUserId(8);
		for(OrderSummaryDetail detail : list){
			OrderDetail order = detail.getOrderDetails().get(0);
			System.out.println(order.getProduct().getProductDesc().getDescription());
		}
	}

}
