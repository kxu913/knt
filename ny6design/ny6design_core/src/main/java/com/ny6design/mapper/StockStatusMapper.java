package com.ny6design.mapper;

import com.ny6design.model.StockStatus;
import com.ny6design.model.StockStatusKey;

public interface StockStatusMapper {
    int deleteByPrimaryKey(StockStatusKey key);

    int insert(StockStatus record);

    int insertSelective(StockStatus record);

    StockStatus selectByPrimaryKey(StockStatusKey key);

    int updateByPrimaryKeySelective(StockStatus record);

    int updateByPrimaryKey(StockStatus record);
}