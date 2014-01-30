package com.ny6design.model;

import java.math.BigDecimal;
import java.util.Date;

public class ProductPrice {
    private Integer productDiscountId;

    private Integer productId;

    private Integer customerGroupId;

    private Integer quantity;

    private Integer priority;

    private BigDecimal price;

    private Date dateStart;

    private Date dateEnd;

    public Integer getProductDiscountId() {
        return productDiscountId;
    }

    public void setProductDiscountId(Integer productDiscountId) {
        this.productDiscountId = productDiscountId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCustomerGroupId() {
        return customerGroupId;
    }

    public void setCustomerGroupId(Integer customerGroupId) {
        this.customerGroupId = customerGroupId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

	@Override
	public String toString() {
		return "ProductPrice [productDiscountId=" + productDiscountId
				+ ", productId=" + productId + ", customerGroupId="
				+ customerGroupId + ", quantity=" + quantity + ", priority="
				+ priority + ", price=" + price + ", dateStart=" + dateStart
				+ ", dateEnd=" + dateEnd + "]";
	}
    
}