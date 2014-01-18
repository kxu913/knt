package com.ny6design.model;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class UserMessage {
	private Integer fmessageid;

	private Integer fuserid;

	private String fdescription;

	private Date fupdatetime;

	public Integer getFmessageid() {
		return fmessageid;
	}

	public void setFmessageid(Integer fmessageid) {
		this.fmessageid = fmessageid;
	}

	public Integer getFuserid() {
		return fuserid;
	}

	public void setFuserid(Integer fuserid) {
		this.fuserid = fuserid;
	}

	public String getFdescription() {
		return fdescription;
	}

	public void setFdescription(String fdescription) {
		this.fdescription = fdescription == null ? null : fdescription.trim();
	}

	public Date getFupdatetime() {
		return fupdatetime;
	}

	public void setFupdatetime(Date fupdatetime) {
		this.fupdatetime = fupdatetime;
	}

	public boolean isValidMessage() {
		if (fuserid != null && !StringUtils.isEmpty(fdescription)) {
			return true;
		}
		return false;
	}
}