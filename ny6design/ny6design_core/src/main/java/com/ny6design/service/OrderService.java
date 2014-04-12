package com.ny6design.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ny6design.mapper.OrderMapper;
import com.ny6design.model.Order;

/**
 * 
 * @author kevin
 * 
 */
@Service
public class OrderService {
	@Autowired
	OrderMapper orderMappper;

	public Order insertOrder(Order order) {
		orderMappper.insert(order);
		return order;
	}

	List<Order> getAllOrdersByUserId(int userId) {
		return orderMappper.getAllOrdersByUserId(userId);
	}

	public void deleteOrder(int orderId) {
		orderMappper.deleteByPrimaryKey(orderId);
	}

	public void updateOrder(Order order) {
		orderMappper.updateByPrimaryKey(order);
	}
}
