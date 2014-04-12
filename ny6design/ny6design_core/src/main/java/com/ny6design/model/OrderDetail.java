package com.ny6design.model;

public class OrderDetail {
	private Order order;
	private Product product;
	// to avoid insert into cart duplicated
	private boolean isInCart =false;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public boolean isInCart() {
		return isInCart;
	}

	public void setInCart(boolean isInCart) {
		this.isInCart = isInCart;
	}
	
}
