package com.ny6design.model;


import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
/**
 * 
 * @author kevin
 *
 */
public class ProductPrice implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9179994798888246851L;

	private long priceId;

	private long productId;

	private String color;

	private String unit;

	private String weight;

	private BigDecimal ourPrice;

	private BigDecimal salePrice1;

	private BigDecimal salePrice2;

	private BigDecimal salePrice3;

	private BigDecimal originalPrice;

	private BigDecimal specialPrice;

	public long getPriceId() {
		return priceId;
	}

	public void setPriceId(long priceId) {
		this.priceId = priceId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public BigDecimal getSalePrice1() {
		return salePrice1;
	}

	public void setSalePrice1(BigDecimal salePrice1) {
		this.salePrice1 = salePrice1;
	}

	public BigDecimal getSalePrice2() {
		return salePrice2;
	}

	public void setSalePrice2(BigDecimal salePrice2) {
		this.salePrice2 = salePrice2;
	}

	public BigDecimal getSalePrice3() {
		return salePrice3;
	}

	public void setSalePrice3(BigDecimal salePrice3) {
		this.salePrice3 = salePrice3;
	}

	public BigDecimal getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}

	public BigDecimal getSpecialPrice() {
		return specialPrice;
	}

	public void setSpecialPrice(BigDecimal specialPrice) {
		this.specialPrice = specialPrice;
	}

	public BigDecimal getOurPrice() {
		return ourPrice;
	}

	public void setOurPrice(BigDecimal ourPrice) {
		this.ourPrice = ourPrice;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Timestamp getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Timestamp updatedTime) {
		this.updatedTime = updatedTime;
	}

	private int qty;

	private String condition;

	private Timestamp updatedTime;

}
