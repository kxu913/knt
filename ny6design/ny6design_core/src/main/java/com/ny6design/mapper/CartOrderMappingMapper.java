package com.ny6design.mapper;

import com.ny6design.model.CartOrderMapping;

public interface CartOrderMappingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CartOrderMapping record);

    int insertSelective(CartOrderMapping record);

    CartOrderMapping selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CartOrderMapping record);

    int updateByPrimaryKey(CartOrderMapping record);

	void deleteByOrderId(int orderId);
}