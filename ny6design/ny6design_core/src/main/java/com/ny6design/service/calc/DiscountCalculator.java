package com.ny6design.service.calc;

import java.math.BigDecimal;

import com.ny6design.model.Discount;

/**
 * calculate discount
 * 
 * @author kxu
 * 
 */
public class DiscountCalculator extends ExtraCalculator{
	private Calculator calculator;
	private Discount discount;
	public DiscountCalculator(Calculator calculator, Discount discount) {
		super();
		this.calculator = calculator;
		this.discount = discount;
	}
	@Override
	public BigDecimal calc() {
		return calculator.calc().subtract(discount.getDiscount());
	}
	
	
}
