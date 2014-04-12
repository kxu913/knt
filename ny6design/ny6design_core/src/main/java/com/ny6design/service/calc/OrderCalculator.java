package com.ny6design.service.calc;

import java.math.BigDecimal;
import java.util.List;

import com.ny6design.model.OrderDetail;

public class OrderCalculator extends Calculator {
	private List<OrderDetail> orderList;

	public OrderCalculator(List<OrderDetail> orderList) {
		super();
		this.orderList = orderList;
	}

	@Override
	public BigDecimal calc() {
		BigDecimal subtotal = BigDecimal.ZERO;
		subtotal.setScale(2);
		if (!orderList.isEmpty()) {
			for (OrderDetail order : orderList) {
				subtotal = subtotal.add(order.getOrder().getCost());
			}
		}
		return subtotal;
	}

}
