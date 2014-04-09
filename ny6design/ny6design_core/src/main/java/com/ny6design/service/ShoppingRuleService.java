package com.ny6design.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ny6design.mapper.ShoppingRuleMapper;
import com.ny6design.model.ShoppingRule;

/**
 * 
 * @author kxu
 * 
 */
@Service
public class ShoppingRuleService {
	@Autowired
	ShoppingRuleMapper shoppingRuleMapper;

	public List<ShoppingRule> getRulesByPage(String html) {
		return shoppingRuleMapper.getRulesByPage(html);
	}
}
