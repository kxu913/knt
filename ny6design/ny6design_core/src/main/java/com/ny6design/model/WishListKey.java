package com.ny6design.model;

public class WishListKey {
	
	
	private Integer productId;

	private Integer userId;

	public WishListKey() {
		super();
	}

	public WishListKey(Integer productId, Integer userId) {
		super();
		this.productId = productId;
		this.userId = userId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "WishListKey [productId=" + productId + ", userId=" + userId
				+ "]";
	}

}