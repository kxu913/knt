package com.ny6design.model;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 
 * @author kevin
 *
 */
public class ProductPic implements Serializable{
	
	private static final long serialVersionUID = 8215977396669780567L; 
	
	private long picId;
	
	private long productId;
	
	private String source;
	
	private Timestamp updatedTime;
	
	public long getPicId() {
		return picId;
	}

	public void setPicId(long picId) {
		this.picId = picId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Timestamp getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Timestamp updatedTime) {
		this.updatedTime = updatedTime;
	}

	

}
