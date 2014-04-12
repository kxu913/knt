package com.ny6design.service.calc;

import java.math.BigDecimal;

import com.ny6design.model.ShipMethod;

/**
 * ship cost
 * 
 * @author kxu
 * 
 */
public class ShipCalculator extends ExtraCalculator {
	private Calculator calculator;
	private ShipMethod shipMethod;

	public ShipCalculator(Calculator calculator, ShipMethod shipMethod) {
		super();
		this.calculator = calculator;
		this.shipMethod = shipMethod;
	}

	@Override
	public BigDecimal calc() {
		return calculator.calc().add(BigDecimal.valueOf(shipMethod.getCost()));
	}

}
