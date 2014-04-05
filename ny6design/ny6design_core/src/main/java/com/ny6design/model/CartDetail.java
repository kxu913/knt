package com.ny6design.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * display whole information of cart
 * 
 * @author kevin
 * 
 */
public class CartDetail {
	private ShoppingCart cart;
	private List<OrderDetail> orders;

	private BigDecimal subtotal;

	public ShoppingCart getCart() {
		return cart;
	}

	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}

	public List<OrderDetail> getOrders() {
		return orders == null ? new ArrayList<OrderDetail>() : orders;
	}

	public void setOrders(List<OrderDetail> orders) {
		this.orders = orders;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

}
