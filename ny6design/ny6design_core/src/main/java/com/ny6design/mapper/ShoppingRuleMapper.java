package com.ny6design.mapper;

import java.util.List;

import com.ny6design.model.ShoppingRule;

public interface ShoppingRuleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShoppingRule record);

    int insertSelective(ShoppingRule record);

    ShoppingRule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShoppingRule record);

    int updateByPrimaryKey(ShoppingRule record);

	List<ShoppingRule> getRulesByPage(String html);
}