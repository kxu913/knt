package com.ny6design.mapper;

import com.ny6design.model.ProductDescription;
import com.ny6design.model.ProductDescriptionKey;

public interface ProductDescriptionMapper {
    int deleteByPrimaryKey(ProductDescriptionKey key);

    int insert(ProductDescription record);

    int insertSelective(ProductDescription record);

    ProductDescription selectByPrimaryKey(ProductDescriptionKey key);

    int updateByPrimaryKeySelective(ProductDescription record);

    int updateByPrimaryKeyWithBLOBs(ProductDescription record);

    int updateByPrimaryKey(ProductDescription record);
}