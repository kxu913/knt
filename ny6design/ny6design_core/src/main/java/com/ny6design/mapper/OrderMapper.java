package com.ny6design.mapper;

import java.util.List;

import com.ny6design.model.Order;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Order record);
    
    List<Order> getAllOrdersByUserId(int userId);
}