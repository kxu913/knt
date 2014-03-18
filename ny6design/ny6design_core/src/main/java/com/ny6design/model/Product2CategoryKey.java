package com.ny6design.model;

public class Product2CategoryKey {
	
	public Product2CategoryKey() {
		super();
	}
	
    public Product2CategoryKey(Integer categoryId, Integer productId) {
		super();
		this.categoryId = categoryId;
		this.productId = productId;
	}

	private Integer categoryId;

    private Integer productId;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

	@Override
	public String toString() {
		return "Product2CategoryKey [categoryId=" + categoryId + ", productId="
				+ productId + "]";
	}
    
}