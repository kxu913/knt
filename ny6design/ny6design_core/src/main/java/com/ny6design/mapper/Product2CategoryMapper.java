package com.ny6design.mapper;

import com.ny6design.model.Product2CategoryKey;

public interface Product2CategoryMapper {
    int deleteByPrimaryKey(Product2CategoryKey key);

    int insert(Product2CategoryKey record);

    int insertSelective(Product2CategoryKey record);
}