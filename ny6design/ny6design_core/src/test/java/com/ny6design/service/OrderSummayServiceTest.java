package com.ny6design.service;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ny6design.core.Env;
import com.ny6design.mapper.OrderSummaryMapper;
import com.ny6design.model.OrderDetail;
import com.ny6design.model.OrderSummary;
import com.ny6design.model.OrderSummaryDetail;

public class OrderSummayServiceTest {
	static ApplicationContext context = new ClassPathXmlApplicationContext("/testContext.xml");
	OrderSummayService orderService;
	OrderSummaryMapper orderSummaryMapper;

	@Before
	public void init() {
		orderService = Env.getBean("orderSummayService");
		orderSummaryMapper = Env.getBean("orderSummaryMapper");
	}

	@Test
	public void testFindOrdersByUserId() {
		List<OrderSummaryDetail> list = orderService.findOrdersByUserId(8);
		OrderSummaryDetail detail = list.get(0);
		OrderSummary summary = new OrderSummary();
		summary.setCreatetime(new Date());
		summary.setOrderNumber(detail.getOrderNumber());
		summary.setDiscountid(1);
		summary.setLastupdatetime(new Date());
		summary.setPaymethodid(1);
		summary.setShipmethodid(1);
		summary.setStatus(1);
		summary.setSubtotal(1d);
		summary.setTotal(1d);
		summary.setUserid(1);
		System.out.println(orderSummaryMapper.insert(summary));
		System.out.println(summary.getId());
		
	}

}
