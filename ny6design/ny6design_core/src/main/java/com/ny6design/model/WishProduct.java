/**
 * wish product info  
 */
package com.ny6design.model;

import java.math.BigDecimal;

/**
 * @author tait
 * 
 */
public class WishProduct {

	private Integer productId;

	private String productName;

	private BigDecimal price;

	private String image;

	private String model;

	private String stockStatus;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getStockStatus() {
		return stockStatus;
	}

	public void setStockStatus(String stockStatus) {
		this.stockStatus = stockStatus;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "WishProduct [productId=" + productId + ", productName="
				+ productName + ", price=" + price + ", image=" + image
				+ ", model=" + model + ", stockStatus=" + stockStatus + "]";
	}

}
