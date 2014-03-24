package com.ny6design.mapper;

import com.ny6design.model.WishListKey;

public interface WishListMapper {
    int deleteByPrimaryKey(WishListKey key);

    int insert(WishListKey record);

    int insertSelective(WishListKey record);
}