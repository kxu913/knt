package com.ny6design.mapper;

import com.ny6design.model.OrderSummaryMapping;

public interface OrderSummaryMappingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderSummaryMapping record);

    int insertSelective(OrderSummaryMapping record);

    OrderSummaryMapping selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderSummaryMapping record);

    int updateByPrimaryKey(OrderSummaryMapping record);
}