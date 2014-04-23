package com.ny6design.model;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * used to store as class
 * 
 * @author kxu
 * 
 */
public class OrderSummaryDetail {
	private Integer id;

	private String orderNumber;
	
	private AddressDetail address;

	private ShipMethod shipmethod;

	private PayMethod paymethod;

	private Discount discount;

	private Double subtotal;

	private Double total;

	private String notice;

	private Integer userid;

	private User user;

	private Integer status;

	private Date createtime;

	private Date lastupdatetime;

	private List<OrderDetail> orderDetails = Collections.emptyList();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public AddressDetail getAddress() {
		return address;
	}

	public void setAddress(AddressDetail address) {
		this.address = address;
	}

	public ShipMethod getShipmethod() {
		return shipmethod;
	}

	public void setShipmethod(ShipMethod shipmethod) {
		this.shipmethod = shipmethod;
	}

	public PayMethod getPaymethod() {
		return paymethod;
	}

	public void setPaymethod(PayMethod paymethod) {
		this.paymethod = paymethod;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice == null ? null : notice.trim();
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getLastupdatetime() {
		return lastupdatetime;
	}

	public void setLastupdatetime(Date lastupdatetime) {
		this.lastupdatetime = lastupdatetime;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

}