package com.ny6design.mapper;

import com.ny6design.model.ProductImage;

public interface ProductImageMapper {
    int deleteByPrimaryKey(Integer productImageId);

    int insertProductImage(ProductImage record);

    int insertSelective(ProductImage record);

    ProductImage selectByPrimaryKey(Integer productImageId);

    int updateByPrimaryKeySelective(ProductImage record);

    int updateByPrimaryKey(ProductImage record);
}