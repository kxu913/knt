package com.ny6design.model;

public class WishListKey {
	private Integer productId;

	private Integer userId;

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