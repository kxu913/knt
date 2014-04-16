package com.ny6design.mapper;

import java.util.List;

import com.ny6design.model.OrderSummary;
import com.ny6design.model.OrderSummaryDetail;

public interface OrderSummaryMapper {
	

	int deleteByPrimaryKey(Integer id);

	int insert(OrderSummary record);

	int insertSelective(OrderSummary record);

	OrderSummary selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(OrderSummary record);

	int updateByPrimaryKey(OrderSummary record);
	
	List<OrderSummaryDetail> selectOrdersByUserId(int userId);
}