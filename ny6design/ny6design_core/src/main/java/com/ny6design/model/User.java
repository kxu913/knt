package com.ny6design.model;

import java.math.BigDecimal;
import java.util.Date;

public class User {
	private Integer userid;

	private String emailaddress;

	private String password;

	private String firstname;

	private String lastname;

	private Integer addressid;

	private String telephone;

	private String fax;

	private BigDecimal taxid;

	private Integer fromid;

	private String factive;
	// used for password
	private byte[] salt;

	private Date updateTime;

	private boolean isAdmin;

	private boolean isPublicEmail;

	private boolean isPublicTel;

	public byte[] getSalt() {
		return salt;
	}

	public void setSalt(byte[] salt) {
		this.salt = salt;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getEmailaddress() {
		return emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress == null ? null : emailaddress.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname == null ? null : firstname.trim();
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname == null ? null : lastname.trim();
	}

	public Integer getAddressid() {
		return addressid;
	}

	public void setAddressid(Integer addressid) {
		this.addressid = addressid;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone == null ? null : telephone.trim();
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax == null ? null : fax.trim();
	}

	public BigDecimal getTaxid() {
		return taxid;
	}

	public void setTaxid(BigDecimal taxid) {
		this.taxid = taxid;
	}

	public Integer getFromid() {
		return fromid;
	}

	public void setFromid(Integer fromid) {
		this.fromid = fromid;
	}

	public String getFactive() {
		return factive;
	}

	public void setFactive(String factive) {
		this.factive = factive == null ? null : factive.trim();
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public boolean isPublicEmail() {
		return isPublicEmail;
	}

	public void setPublicEmail(boolean isPublicEmail) {
		this.isPublicEmail = isPublicEmail;
	}

	public boolean isPublicTel() {
		return isPublicTel;
	}

	public void setPublicTel(boolean isPublicTel) {
		this.isPublicTel = isPublicTel;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", emailaddress=" + emailaddress
				+ ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", addressid=" + addressid
				+ ", telephone=" + telephone + ", fax=" + fax + ", taxid="
				+ taxid + ", fromid=" + fromid + ", factive=" + factive
				+ ", updateTime="
				+ updateTime + ", isAdmin=" + isAdmin + ", isPublicEmail="
				+ isPublicEmail + ", isPublicTel=" + isPublicTel + "]";
	}

}