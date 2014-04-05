package com.ny6design.constant;

/**
 * the status of a product which had added into shopping cart
 * 
 * @author kevin
 * 
 */
public enum OrderStatus {
	/*a productCode added */Added((short)0), Canceled((short)-1), Payed((short)1);
	public short actualValue = 0;

	OrderStatus(short actualValue) {
		this.actualValue = actualValue;
	}

}
