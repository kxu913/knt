package com.ny6design.model;

import java.util.Date;

public class OrderSummary {
    private Integer id;
    
    private String orderNumber;

    private Integer shipmethodid;

    private Integer paymethodid;

    private Integer discountid;

    private Double subtotal;

    private Double total;

    private String notice;

    private Integer userid;
    
    private Integer addressId;

    private Integer status;

    private Date createtime;

    private Date lastupdatetime;

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

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public Integer getShipmethodid() {
        return shipmethodid;
    }

    public void setShipmethodid(Integer shipmethodid) {
        this.shipmethodid = shipmethodid;
    }

    public Integer getPaymethodid() {
        return paymethodid;
    }

    public void setPaymethodid(Integer paymethodid) {
        this.paymethodid = paymethodid;
    }

    public Integer getDiscountid() {
        return discountid;
    }

    public void setDiscountid(Integer discountid) {
        this.discountid = discountid;
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
}