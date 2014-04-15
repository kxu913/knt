package com.ny6design.constant;

/**
 * used to store order status
 * 
 * @author kxu
 * 
 */
public enum OrderSummaryStatus {
	Creatd(1), Shipped(2), Finished(3);
	int id;

	private OrderSummaryStatus(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
