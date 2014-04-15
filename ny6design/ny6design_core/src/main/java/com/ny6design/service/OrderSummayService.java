package com.ny6design.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ny6design.constant.OrderStatus;
import com.ny6design.constant.OrderSummaryStatus;
import com.ny6design.mapper.OrderSummaryMapper;
import com.ny6design.mapper.OrderSummaryMappingMapper;
import com.ny6design.model.CartDetail;
import com.ny6design.model.Order;
import com.ny6design.model.OrderDetail;
import com.ny6design.model.OrderSummary;
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

	public void insertOrder(CartDetail detail) {
		OrderSummary summary = new OrderSummary();
		this.setDefaltValue(summary);
		this.setValueFromDetail(summary, detail);
		int summaryId = orderSummaryMapper.insert(summary);
		List<OrderDetail> orders = detail.getOrders();
		if(orders!=null && !orders.isEmpty()){
			for(OrderDetail order :orders){
				OrderSummaryMapping mapping = new OrderSummaryMapping();
				mapping.setOrderid(order.getOrder().getId());
				mapping.setOrdersummaryid(summaryId);
				orderSummaryMappingMapper.insert(mapping);
			}
		}

	}

	private void setDefaltValue(OrderSummary summary) {
		Date currentDate = new Date();
		summary.setCreatetime(currentDate);
		summary.setLastupdatetime(currentDate);
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
	}
}
