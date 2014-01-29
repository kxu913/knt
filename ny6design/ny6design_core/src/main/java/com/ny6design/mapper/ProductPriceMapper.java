package com.ny6design.mapper;

import com.ny6design.model.ProductPrice;

public interface ProductPriceMapper {
    int deleteByPrimaryKey(Integer productDiscountId);

    int insert(ProductPrice record);

    int insertSelective(ProductPrice record);

    ProductPrice selectByPrimaryKey(Integer productDiscountId);

    int updateByPrimaryKeySelective(ProductPrice record);

    int updateByPrimaryKey(ProductPrice record);
}