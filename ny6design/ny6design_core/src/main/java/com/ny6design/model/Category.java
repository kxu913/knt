package com.ny6design.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;
/**
 * 
 * @author kevin
 *
 */
public class Category implements Serializable{
	
	private static final long serialVersionUID = 4125965356358329466L;
	
	private long categoryId;
	
	private String name;
	private String parentName;
	private String[] childrenName;//not used now 2014/2/6
	
	private int order = 1;
	
	private long parentId = -1;
	
	private int validated = 1;
	
	

	public int getValidated() {
		return validated;
	}

	public void setValidated(int validated) {
		this.validated = validated;
	}

	private Timestamp updateTime = new Timestamp(System.currentTimeMillis());

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String[] getChildrenName() {
		return childrenName;
	}

	public void setChildrenName(String[] childrenName) {
		this.childrenName = childrenName;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", name=" + name
				+ ", parentName=" + parentName + ", childName="
				+ Arrays.toString(childrenName) + ", order=" + order
				+ ", parentId=" + parentId + ", validated=" + validated
				+ ", updateTime=" + updateTime + "]";
	}
	
}
