package com.ny6design.model;


import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
/**
 * 
 * @author kevin
 *
 */
public class Product implements Serializable {

	private static final long serialVersionUID = 451949797460417653L;

	private long productId;

	private String name;

	private String displayName;

	private long categoryId;

	private int saleFlag;

	private String shipTime;

	private int sellQty;

	private int inventoryQty;

	private Date availableDate;

	private int validation = 1;

	private Timestamp updatedTime;

	private Timestamp createTime;

	private List<ProductPic> pictureSources;

	private List<ProductPrice> prices;

	private int soldOutFlag;

	private int recommend;

	private String description;

	public int getRecommend() {
		return recommend;
	}

	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}

	public int getSoldOutFlag() {
		return soldOutFlag;
	}

	public void setSoldOutFlag(int soldOutFlag) {
		this.soldOutFlag = soldOutFlag;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public int getSaleFlag() {
		return saleFlag;
	}

	public void setSaleFlag(int saleFlag) {
		this.saleFlag = saleFlag;
	}

	public String getShipTime() {
		return shipTime;
	}

	public void setShipTime(String shipTime) {
		this.shipTime = shipTime;
	}

	public int getSellQty() {
		return sellQty;
	}

	public void setSellQty(int sellQty) {
		this.sellQty = sellQty;
	}

	public int getInventoryQty() {
		return inventoryQty;
	}

	public void setInventoryQty(int inventoryQty) {
		this.inventoryQty = inventoryQty;
	}

	public Date getAvailableDate() {
		return availableDate;
	}

	public void setAvailableDate(Date availableDate) {
		this.availableDate = availableDate;
	}

	public int getValidation() {
		return validation;
	}

	public void setValidation(int validation) {
		this.validation = validation;
	}

	public Timestamp getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Timestamp updatedTime) {
		this.updatedTime = updatedTime;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public List<ProductPic> getPictureSources() {
		return pictureSources;
	}

	public void setPictureSources(List<ProductPic> pictureSources) {
		this.pictureSources = pictureSources;
	}

	public List<ProductPrice> getPrices() {
		return prices;
	}

	public void setPrices(List<ProductPrice> prices) {
		this.prices = prices;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
