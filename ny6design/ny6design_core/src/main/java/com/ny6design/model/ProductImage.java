package com.ny6design.model;

import org.hibernate.validator.constraints.NotEmpty;

public class ProductImage {
	
    private Integer productImageId;

    private Integer productId;

    @NotEmpty
    private String image;

    public Integer getProductImageId() {
        return productImageId;
    }

    public void setProductImageId(Integer productImageId) {
        this.productImageId = productImageId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

	@Override
	public String toString() {
		return "ProductImage [productImageId=" + productImageId
				+ ", productId=" + productId + ", image=" + image + "]";
	}
    
}