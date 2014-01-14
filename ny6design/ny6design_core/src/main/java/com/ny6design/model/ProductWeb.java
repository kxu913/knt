package com.ny6design.model;


import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * 
 * @author kevin
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductWeb extends Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4535316215181780103L;

	private boolean special;

	private boolean hotItem;

	private boolean newItem;

	private boolean mixSale;

	private boolean recommend;

	public boolean isRecommend() {
		return recommend;
	}

	public void setRecommend(boolean recommend) {
		this.recommend = recommend;
	}

	public boolean isSpecial() {
		return special;
	}

	public void setSpecial(boolean special) {
		this.special = special;
	}

	public boolean isHotItem() {
		return hotItem;
	}

	public void setHotItem(boolean hotItem) {
		this.hotItem = hotItem;
	}

	public boolean isNewItem() {
		return newItem;
	}

	public void setNewItem(boolean newItem) {
		this.newItem = newItem;
	}

	public boolean isMixSale() {
		return mixSale;
	}

	public void setMixSale(boolean mixSale) {
		this.mixSale = mixSale;
	}

	public void constructSaleFlag() {
		// 0001 1111
		int flag = 0x001f;
		// 0000 0001 for hot item, 00010 for specials, 00100 for new item,01000
		// for mixsale, 10000 for recommend
		if (!isHotItem()) {
			flag = flag & 0xfffe;
		}

		if (!isSpecial()) {
			flag = flag & 0xfffd;
		}

		if (!isHotItem()) {
			flag = flag & 0xfffb;
		}

		if (!isMixSale()) {
			flag = flag & 0xfff7;
		}

		if (!isRecommend()) {
			flag = flag & 0xffef;
		}

		this.setSaleFlag(flag);
	}

	// -------------------------------------------------------------ProductPrice

	private BigDecimal originalPrice;

	private BigDecimal salePrice;

	public BigDecimal getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public BigDecimal getDiscountPrice1() {
		return discountPrice1;
	}

	public void setDiscountPrice1(BigDecimal discountPrice1) {
		this.discountPrice1 = discountPrice1;
	}

	public BigDecimal getDiscountPrice2() {
		return discountPrice2;
	}

	public void setDiscountPrice2(BigDecimal discountPrice2) {
		this.discountPrice2 = discountPrice2;
	}

	public BigDecimal getDiscountPrice3() {
		return discountPrice3;
	}

	public void setDiscountPrice3(BigDecimal discountPrice3) {
		this.discountPrice3 = discountPrice3;
	}

	private BigDecimal discountPrice1;

	private BigDecimal discountPrice2;

	private BigDecimal discountPrice3;

	private String condition;

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
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

	private String color;

	private String unit;

	private String weight;

	public void constructPriceList() {

		List<ProductPrice> priceList = new ArrayList<ProductPrice>();
		Timestamp current = new Timestamp(System.currentTimeMillis());
		// original price
		ProductPrice price = new ProductPrice();
		price.setColor(getColor());
		price.setCondition(getCondition());
		price.setUnit(getUnit());
		price.setQty(getInventoryQty());
		price.setUpdatedTime(current);
		price.setOriginalPrice(getOriginalPrice());
		price.setOurPrice(getSalePrice());
		price.setSalePrice1(getDiscountPrice1());
		price.setSalePrice2(getDiscountPrice2());
		price.setSalePrice3(getDiscountPrice3());
		priceList.add(price);

		this.setPrices(priceList);
	}

	// ------------------------------------------------------------- ProductPic
	private List<String> sources = new ArrayList<String>();

	public List<String> getSources() {
		return sources;
	}

	public void setSources(List<String> sources) {
		this.sources = sources;
	}

	public void constructProductPictures() {
		
		List<ProductPic> pictures = new ArrayList<ProductPic>();
		for (String souce : getSources()) {
			
			Timestamp current = new Timestamp(System.currentTimeMillis());

			ProductPic pic = new ProductPic();
			pic.setSource(souce);
			
			pic.setUpdatedTime(current);
			pictures.add(pic);
			
		}
		this.setPictureSources(pictures);
	}

}
