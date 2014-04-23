package com.ny6design.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ny6design.constant.OrderStatus;
import com.ny6design.constant.OrderSummaryStatus;
import com.ny6design.core.ThreadLocalRandom;
import com.ny6design.mapper.OrderSummaryMapper;
import com.ny6design.mapper.OrderSummaryMappingMapper;
import com.ny6design.model.CartDetail;
import com.ny6design.model.OrderDetail;
import com.ny6design.model.OrderSummary;
import com.ny6design.model.OrderSummaryDetail;
import com.ny6design.model.OrderSummaryMapping;

/**
 * 
 * @author kxu
 * 
 */
@Service
public class OrderSummayService {
	@Autowired
	OrderSummaryMapper orderSummaryMapper;

	@Autowired
	OrderSummaryMappingMapper orderSummaryMappingMapper;
	
	@Autowired
	OrderService orderService;

	ThreadLocal<SimpleDateFormat> df = new ThreadLocal<SimpleDateFormat>() {

		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyyMMddHHmmss");
		}

	};

	public void insertOrder(CartDetail detail) {
		OrderSummary summary = new OrderSummary();
		this.setDefaltValue(summary);
		this.setValueFromDetail(summary, detail);
		orderSummaryMapper.insert(summary);
		int summaryId = summary.getId();
		List<OrderDetail> orders = detail.getOrders();
		if (orders != null && !orders.isEmpty()) {
			for (OrderDetail order : orders) {
				OrderSummaryMapping mapping = new OrderSummaryMapping();
				mapping.setOrderid(order.getOrder().getId());
				mapping.setOrdersummaryid(summaryId);
				orderSummaryMappingMapper.insert(mapping);
				order.getOrder().setStatus(OrderStatus.Created.actualValue);
				orderService.updateOrder(order.getOrder());
			}
		}

	}

	/**
	 * create 18 length order number
	 * 
	 * @param order
	 * @return
	 */
	private String createOrderNumber(Date currentDate) {
		return df.get().format(currentDate) + ThreadLocalRandom.current().getFixedLengthRandom(4);
	}

	private void setDefaltValue(OrderSummary summary) {
		Date currentDate = new Date();
		summary.setCreatetime(currentDate);
		summary.setLastupdatetime(currentDate);
		summary.setOrderNumber(createOrderNumber(currentDate));
		summary.setStatus(OrderSummaryStatus.Creatd.getId());
	}

	private void setValueFromDetail(OrderSummary summary, CartDetail detail) {
		// TODO add discount
		summary.setDiscountid(1);
		summary.setNotice(detail.getNotice());
		summary.setPaymethodid(detail.getPayMethod().getId());
		summary.setShipmethodid(detail.getShipMethod().getId());
		summary.setSubtotal(detail.getTotal().doubleValue());
		summary.setTotal(detail.getTotal().doubleValue());
		summary.setUserid(detail.getCart().getUserId());
		summary.setAddressId(detail.getCart().getAddressId());
	}

	public List<OrderSummaryDetail> findOrdersByUserId(int userId) {
		return orderSummaryMapper.selectOrdersByUserId(userId);
	}

	public OrderSummaryDetail getOrderDetailById(int orderId) {
		return orderSummaryMapper.getOrderDetailById(orderId);
	}
}
