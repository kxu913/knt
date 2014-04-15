package com.ny6design.mapper;

import com.ny6design.model.OrderSummary;

public interface OrderSummaryMapper {
	

	int deleteByPrimaryKey(Integer id);

	int insert(OrderSummary record);

	int insertSelective(OrderSummary record);

	OrderSummary selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(OrderSummary record);

	int updateByPrimaryKey(OrderSummary record);
}